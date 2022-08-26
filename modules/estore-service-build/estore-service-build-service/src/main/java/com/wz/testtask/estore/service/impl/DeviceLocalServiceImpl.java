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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.wz.testtask.estore.exception.*;
import com.wz.testtask.estore.model.Device;
import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil;
import com.wz.testtask.estore.service.PurchaseLocalServiceUtil;
import com.wz.testtask.estore.service.base.DeviceLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author wz
 */
@Component(
        property = "model.class.name=com.wz.testtask.estore.model.Device",
        service = AopService.class
)
public class DeviceLocalServiceImpl extends DeviceLocalServiceBaseImpl {
    
    /**
     * Creates new record of device
     *
     * @param name
     * @param price
     * @param deviceTypeId
     * @param count
     * @param inStock
     * @param archive
     * @param description
     * @param serviceContext
     * @return
     * @throws PortalException if device type with given id does not exist or when validation fails
     */
    public Device addDevice(String name, long price, long deviceTypeId,
                            int count, boolean inStock,
                            boolean archive, String description, ServiceContext serviceContext)
            throws PortalException {
        DeviceType deviceType = DeviceTypeLocalServiceUtil.getDeviceType(deviceTypeId);
        long deviceId = counterLocalService.increment();
        Device device = devicePersistence.create(deviceId);
        device.setGroupId(serviceContext.getScopeGroupId());
        device.setCompanyId(serviceContext.getCompanyId());
        device.setName(name);
        device.setPrice(price);
        device.setDeviceTypeId(deviceType.getDeviceTypeId());
        device.setDescription(description);
        device.setArchive(archive);
        device.setInStock(inStock);
        device.setCount(count);
        
        validate(device);
        return devicePersistence.update(device);
    }
    
    /**
     * Creates new record of device, set inStock state true if count is greater than 0
     * @param name
     * @param price
     * @param deviceTypeId
     * @param count
     * @param archive
     * @param description
     * @param serviceContext
     * @return
     * @throws PortalException
     */
    public Device addDevice(String name, long price, long deviceTypeId,
                            int count, boolean archive,
                            String description, ServiceContext serviceContext) throws PortalException {
        return addDevice(name, price, deviceTypeId, count, count > 0, archive, description, serviceContext);
    }
    
    /**
     * @param deviceId
     * @param name
     * @param price
     * @param deviceTypeId
     * @param count
     * @param inStock
     * @param archive
     * @param description
     * @param serviceContext
     * @return
     * @throws PortalException if device or device type with given id does not exist
     */
    public Device updateDevice(long deviceId, String name, long price, long deviceTypeId,
                               int count, boolean inStock,
                               boolean archive, String description, ServiceContext serviceContext) throws PortalException {
        DeviceType deviceType = DeviceTypeLocalServiceUtil.getDeviceType(deviceTypeId);
        Device device = devicePersistence.findByPrimaryKey(deviceId);
        device.setName(name);
        device.setPrice(price);
        device.setDeviceTypeId(deviceType.getDeviceTypeId());
        device.setDescription(description);
        device.setArchive(archive);
        device.setInStock(inStock);
        device.setCount(count);
        validate(device);
        return devicePersistence.update(device);
    }
    
    public Device updateDevice(long deviceId, String name, long price, long deviceTypeId,
                               int count, boolean archive,
                               String description, ServiceContext serviceContext) throws PortalException {
        return updateDevice(deviceId, name, price, deviceTypeId, count, count > 0, archive, description, serviceContext);
    }
    
    /**
     * Sets device's archived state.
     *
     * @param deviceId       - device Id
     * @param archive        - archived state false - not archived, true - archived
     * @param serviceContext - service context
     * @return updated device
     * @throws PortalException if device with given id does not exist
     */
    public Device setArchiveState(long deviceId, boolean archive,
                                  ServiceContext serviceContext) throws PortalException {
        Device device = devicePersistence.findByPrimaryKey(deviceId);
        device.setArchive(archive);
        return devicePersistence.update(device);
    }
    
    public Device deleteById(long deviceId, ServiceContext serviceContext) throws PortalException {
        return delete(devicePersistence.findByPrimaryKey(deviceId), serviceContext);
    }
    
    public Device delete(Device device, ServiceContext serviceContext) throws PortalException {
        long groupId = serviceContext.getScopeGroupId();
        if (PurchaseLocalServiceUtil.getPurchasesOfDeviceCount(groupId, device.getDeviceId()) == 0) {
            return devicePersistence.remove(device);
        } else
            throw new ConsistencyViolationException("You are not allowed to remove a device " +
                    " there are purchases attached to it");
    }
    
    public List<Device> getDevices(long groupId) {
        
        return devicePersistence.findByGroupId(groupId);
    }
    
    public List<Device> getDevices(long groupId, int start, int end,
                                   OrderByComparator<Device> obc) {
        
        return devicePersistence.findByGroupId(groupId, start, end, obc);
    }
    
    public List<Device> getDevices(long groupId, int start, int end) {
        
        return devicePersistence.findByGroupId(groupId, start, end);
    }
    
    public int getDevicesCount(long groupId) {
        return devicePersistence.countByGroupId(groupId);
    }
    
    public Device fetchDeviceByName(long groupId, String name){
        return devicePersistence.fetchByName(groupId, name);
    }
    
    protected void validate(Device device) throws PortalException {
        if (Validator.isNull(device)) {
            throw new IllegalReferenceException();
        }
        if (Validator.isNull(device.getName()) || Validator.isBlank(device.getName())) {
            throw new EmptyFieldException("Name can not be empty");
        }
        if (device.getPrice() <= 0) {
            throw new IllegalPriceValueException("Price can not be less or equal to zero");
        }
        if (device.getCount() < 0) {
            throw new IllegalDeviceCountValueException("Devices count can not be less than zero");
        }
        if (device.getCount() == 0 && device.getInStock()) {
            throw new IllegalDeviceCountValueException("Device must be out of stock if it's count is equal to zero");
        }
    }
}