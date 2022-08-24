/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.wz.testtask.estore.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.wz.testtask.estore.exception.*;
import com.wz.testtask.estore.model.Device;
import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.model.Purchase;
import com.wz.testtask.estore.model.PurchaseType;
import com.wz.testtask.estore.service.DeviceLocalServiceUtil;
import com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil;
import com.wz.testtask.estore.service.PurchaseTypeLocalServiceUtil;
import com.wz.testtask.estore.service.base.PurchaseLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author wz
 */
@Component(
        property = "model.class.name=com.wz.testtask.estore.model.Purchase",
        service = AopService.class
)
public class PurchaseLocalServiceImpl extends PurchaseLocalServiceBaseImpl {
    private static final Log logger = LogFactoryUtil.getLog(PurchaseLocalServiceImpl.class);
    
    public void makePurchase(long employeeId, long deviceId, int count,
                             long purchaseTypeId, ServiceContext serviceContext) throws PortalException {
        logger.info(String.format("Making purchase by employee: %d device: %d count: %d purchase type: %d",
                employeeId, deviceId, count, purchaseTypeId));

        long purchaseId = counterLocalService.increment();
        Purchase purchase = purchaseLocalService.createPurchase(purchaseId);
        purchase.setGroupId(serviceContext.getScopeGroupId());
        purchase.setCompanyId(serviceContext.getCompanyId());
        purchase.setEmployeeId(employeeId);
        purchase.setPurchaseTypeId(purchaseTypeId);
        purchase.setDeviceId(deviceId);
        purchase.setPurchasedDate(new Date());
        purchase.setCount(count);
        validateNewPurchase(purchase);
        
        logger.info("Validation passed. Making purchase");
        
        purchasePersistence.update(purchase);
        Device device = DeviceLocalServiceUtil.getDevice(purchase.getDeviceId());
        device.setCount(device.getCount() - count);
        if (device.getCount() == 0)
            device.setInStock(false);
        DeviceLocalServiceUtil.updateDevice(device);
    }
    
    public void updatePurchase(long purchaseId, long employeeId, long deviceId, int count,
                               long purchaseTypeId, ServiceContext serviceContext) throws PortalException{
        logger.info(String.format("Updating purchase: %d for employee: %d device: %d count: %d purchase type: %d",
                purchaseId, employeeId, deviceId, count, purchaseTypeId));
        
        Purchase purchase = purchasePersistence.findByPrimaryKey(purchaseId);
        int previousCount = purchase.getCount();
        long previousDeviceId = purchase.getDeviceId();
        purchase.setEmployeeId(employeeId);
        purchase.setPurchaseTypeId(purchaseTypeId);
        purchase.setDeviceId(deviceId);
        purchase.setCount(count);
        validateUpdatedPurchase(purchase, previousDeviceId, previousCount);
    
        logger.info("Validation passed. Updating purchase");
        
        purchasePersistence.update(purchase);
        
        if(previousDeviceId == purchase.getDeviceId()){
            int delta = purchase.getCount() - previousCount;
            Device device = DeviceLocalServiceUtil.getDevice(purchase.getDeviceId());
            device.setCount(device.getCount() - delta);
            device.setInStock(device.getCount() > 0);
            DeviceLocalServiceUtil.updateDevice(device);
        }
        else{
            Device previousDevice = DeviceLocalServiceUtil.getDevice(previousDeviceId);
            previousDevice.setCount(previousDevice.getCount() + previousCount);
            previousDevice.setInStock(previousDevice.getCount() > 0);
    
            Device device = DeviceLocalServiceUtil.getDevice(purchase.getDeviceId());
            device.setCount(device.getCount() - purchase.getCount());
            device.setInStock(device.getCount() > 0);
            
            DeviceLocalServiceUtil.updateDevice(previousDevice);
            DeviceLocalServiceUtil.updateDevice(device);
        }
    }
    
    public List<Purchase> getPurchases(long groupId) {
        
        return purchasePersistence.findByGroupId(groupId);
    }
    
    public List<Purchase> getPurchases(long groupId, int start, int end,
                                       OrderByComparator<Purchase> obc) {
        
        return purchasePersistence.findByGroupId(groupId, start, end, obc);
    }
    
    public List<Purchase> getPurchases(long groupId, int start, int end) {
        
        return purchasePersistence.findByGroupId(groupId, start, end);
    }
    
    public int getPurchasesCount(long groupId) {
        return purchasePersistence.countByGroupId(groupId);
    }
    
    
    public List<Purchase> getPurchasesForEmployee(long groupId, long employeeId) {
        return purchasePersistence.findByGroupIdEmployeeId(groupId, employeeId);
    }
    
    public int getPurchasesForEmployeeCount(long groupId, long employeeId) {
        return purchasePersistence.countByGroupIdEmployeeId(groupId, employeeId);
    }
    
    public List<Purchase> getPurchasesOfDevice(long groupId, long deviceId) {
        return purchasePersistence.findByGroupIdDeviceId(groupId, deviceId);
    }
    
    public int getPurchasesOfDeviceCount(long groupId, long deviceId) {
        return purchasePersistence.countByGroupIdDeviceId(groupId, deviceId);
    }
    
    /**
     * Check if purchase can be performed. Checks whether employee is allowed to sign it, whether there is enough
     * devices in stock or it is archived.
     * @param purchase
     * @throws PortalException
     */
    protected void validateNewPurchase(Purchase purchase) throws PortalException{
        logger.info("Validating purchase...");
        Device device = DeviceLocalServiceUtil.getDevice(purchase.getDeviceId());
        List<DeviceType> deviceTypesEmployeeConsult = DeviceTypeLocalServiceUtil.getEmployeeDeviceTypes(purchase.getEmployeeId());
        PurchaseType purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseType(purchase.getPurchaseTypeId());
        
        if (deviceTypesEmployeeConsult.stream().noneMatch(d -> d.getDeviceTypeId() == device.getDeviceTypeId())) {
            throw new EmployeeIsNotResponsibleException("Employee can not sign this purchase");
        }
    
        if(purchase.getCount() <= 0 )
            throw new WrongAmountOfDevicesException("Count can not be less or equal to 0");
        
        if (device.isArchive())
            throw new DeviceIsArchivedException("Device is archived");

        if (!device.getInStock() || device.getCount() < purchase.getCount())
            throw new DeviceIsOutOfStockException("Not enough devices in stock");
    }
    
    /**
     * Check if purchase can be performed. Checks whether employee is allowed to sign it, whether there is enough
     * devices in stock or it is archived.
     * @param purchase
     * @throws PortalException
     */
    protected void validateUpdatedPurchase(Purchase purchase, long previousDeviceId, int previousCount)
            throws PortalException{
        
        Device device = DeviceLocalServiceUtil.getDevice(purchase.getDeviceId());
        List<DeviceType> deviceTypesEmployeeConsult = DeviceTypeLocalServiceUtil.getEmployeeDeviceTypes(purchase.getEmployeeId());
        PurchaseType purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseType(purchase.getPurchaseTypeId());
    
        logger.info(String.format("Validating purchase for update devices are current: %d, count: %d" +
                        ", previous: %d, previous count: %d",
                purchase.getDeviceId(), device.getCount(), previousDeviceId, previousCount));
        
        if (deviceTypesEmployeeConsult.stream().noneMatch(d -> d.getDeviceTypeId() == device.getDeviceTypeId())) {
            logger.error(String.format("Employee %d can not sign this purchase", purchase.getEmployeeId()));
            throw new EmployeeIsNotResponsibleException("Employee can not sign this purchase");
        }
        
        if(purchase.getCount() <= 0 ){
            logger.error("Amount is less than 0");
            throw new WrongAmountOfDevicesException("Count can not be less or equal to 0");
        }
        
        
        if (device.isArchive()){
            logger.error("Device is archived");
            throw new DeviceIsArchivedException("Device is archived");
        }
        
        
        if(previousDeviceId == purchase.getDeviceId()){
            if(device.getCount() + previousCount - purchase.getCount() < 0){
                logger.error(String.format("Can't buy same item. Given amount is greater (%d) " +
                        "than there is in stock %d", purchase.getCount(), device.getCount() + previousCount ));
                throw new DeviceIsOutOfStockException("Not enough devices in stock");
            }
        }
        else{
            if(device.getCount() - purchase.getCount() < 0){
                logger.error(String.format("Can't buy another item. Given amount is greater (%d) " +
                        "than there is in stock %d", purchase.getCount(), device.getCount() ));
                throw new DeviceIsOutOfStockException("Not enough devices in stock");
            }
        }
        
            
            
    }
}