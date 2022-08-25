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
import com.liferay.portal.kernel.util.Validator;
import com.wz.testtask.estore.exception.*;
import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.model.Employee;
import com.wz.testtask.estore.model.EmployeePosition;
import com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil;
import com.wz.testtask.estore.service.EmployeeLocalServiceUtil;
import com.wz.testtask.estore.service.EmployeePositionLocalServiceUtil;
import com.wz.testtask.estore.service.PurchaseLocalServiceUtil;
import com.wz.testtask.estore.service.base.EmployeeLocalServiceBaseImpl;
import com.wz.testtask.estore.service.persistence.impl.constants.EmployeeConstants;
import org.osgi.service.component.annotations.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wz
 */
@Component(
        property = "model.class.name=com.wz.testtask.estore.model.Employee",
        service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
    private static final Log logger = LogFactoryUtil.getLog(EmployeeLocalServiceImpl.class);
    
    /**
     * @param firstName      employee's first name
     * @param lastName       employee's last name
     * @param patronymic     employee's patronymic
     * @param birthDate      employee's birth date
     * @param gender         a value from {@link com.wz.testtask.estore.service.persistence.impl.constants.EmployeeConstants.GENDER}
     *                       representing person's gender
     * @param serviceContext
     * @return created instance
     */
    public Employee addEmployee(String firstName, String lastName,
                                String patronymic, Date birthDate,
                                String gender, long positionId, ServiceContext serviceContext)
            throws PortalException {
        EmployeePosition position = EmployeePositionLocalServiceUtil.getEmployeePosition(positionId);
        long groupId = serviceContext.getScopeGroupId();
        long entryId = counterLocalService.increment();
        Employee employee = employeePersistence.create(entryId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setCompanyId(serviceContext.getCompanyId());
        employee.setPatronymic(patronymic);
        employee.setBirthDate(birthDate);
        employee.setGender(EmployeeConstants.GENDER.valueOf(gender).getValue());
        employee.setGroupId(groupId);
        employee.setPositionId(positionId);
        validate(employee);
        return employeePersistence.update(employee);
    }
    
    public Employee updateEmployee(long employeeId, String firstName, String lastName,
                                   String patronymic, Date birthDate,
                                   String gender, long positionId, ServiceContext serviceContext) throws PortalException {
        EmployeePosition position = EmployeePositionLocalServiceUtil.getEmployeePosition(positionId);
        Employee employee = employeePersistence.findByPrimaryKey(employeeId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setCompanyId(serviceContext.getCompanyId());
        employee.setPatronymic(patronymic);
        employee.setBirthDate(birthDate);
        employee.setGender(EmployeeConstants.GENDER.valueOf(gender).getValue());
        employee.setPositionId(positionId);
        validate(employee);
        return employeePersistence.update(employee);
    }
    
    public Employee setEmployeePosition(long employeeId, long positionId,
                                        ServiceContext serviceContext) throws PortalException {
        Employee employee = employeePersistence.findByPrimaryKey(employeeId);
        employee.setPositionId(positionId);
        return employeePersistence.update(employee);
    }
    
    public Employee deleteById(long employeeId, ServiceContext serviceContext) throws PortalException {
        return delete(employeePersistence.findByPrimaryKey(employeeId), serviceContext);
    }
    
    public Employee delete(Employee employee, ServiceContext serviceContext) throws PortalException {
        long groupId = serviceContext.getScopeGroupId();
        List<DeviceType> deviceTypes = DeviceTypeLocalServiceUtil.getEmployeeDeviceTypes(employee.getEmployeeId());
        for(DeviceType deviceType : deviceTypes){
            DeviceTypeLocalServiceUtil.deleteEmployeeDeviceType(employee.getEmployeeId(), deviceType.getDeviceTypeId());
        }
        if (PurchaseLocalServiceUtil.getPurchasesForEmployeeCount(groupId, employee.getEmployeeId()) == 0 ) {
            return employeePersistence.remove(employee);
        } else
            throw new ConsistencyViolationException("You are not allowed to remove an employee " +
                    " as he/she has one or more purchases signed by him");
    }
    
    public List<Employee> getEmployees(long groupId) {
        
        return employeePersistence.findByGroupId(groupId);
    }
    
    public List<Employee> getEmployees(long groupId, int start, int end,
                                       OrderByComparator<Employee> obc) {
        
        return employeePersistence.findByGroupId(groupId, start, end, obc);
    }
    
    public List<Employee> getEmployees(long groupId, int start, int end) {
        
        return employeePersistence.findByGroupId(groupId, start, end);
    }
    
    public int getEmployeesCount(long groupId) {
        return employeePersistence.countByGroupId(groupId);
    }
    
    public String getGenderById(int genderId){
        return EnumSet.allOf(EmployeeConstants.GENDER.class)
                .stream()
                .filter(g -> g.getValue() == genderId)
                .findFirst()
                .orElse(EmployeeConstants.GENDER.UNKNOWN).toString();
    }
    
    public List<String> getGenderList(){
        return EnumSet.allOf(EmployeeConstants.GENDER.class)
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList());
    }
    
    protected void validate(Employee employee) throws PortalException {
        if (Validator.isNull(employee)) {
            throw new IllegalReferenceException();
        }
        if (Validator.isNull(employee.getFirstName()) || Validator.isBlank(employee.getFirstName())) {
            throw new EmptyPersonNameException("First name can not be empty");
        }
        if (Validator.isNull(employee.getLastName()) || Validator.isBlank(employee.getLastName())) {
            throw new EmptyPersonNameException("Last name can not be empty");
        }
        if (Validator.isNull(employee.getPatronymic()) || Validator.isBlank(employee.getPatronymic())) {
            throw new EmptyPersonNameException("Patronymic can not be empty");
        }
        if (Validator.isNull(employee.getBirthDate())) {
            throw new EmptyFieldException("Birth date can not be empty");
        }
        if (Date.from(Instant.now()).before(employee.getBirthDate())) {
            throw new InvalidBirthDateException("Birth date can be later than today");
        }
    }
}