package com.wz.testtask.estore.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.wz.testtask.estore.exception.DataFormatException;
import com.wz.testtask.estore.model.Device;
import com.wz.testtask.estore.model.Employee;
import com.wz.testtask.estore.model.EmployeePosition;
import com.wz.testtask.estore.model.PurchaseType;
import com.wz.testtask.estore.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseCsvTableReader implements CsvTableReader{
    private static final Log logger = LogFactoryUtil.getLog(EmployeeCsvTableReader.class);
    
    @Override
    public boolean isSuitable(String fileName) {
        return fileName.toLowerCase().equals("ESTORE_Purchase.csv".toLowerCase());
    }
    
    @Override
    public void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException {
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                String[] values = line.split(",");
                if (values.length != 5) {
                    logger.error("Invalid params count in csv string");
                    throw new DataFormatException("Invalid params count in csv file string");
                }
                String[] employeeFullName = values[0].split(" ");
                String firstName = employeeFullName[0];
                String lastName = employeeFullName[1];
                String patronymic = employeeFullName[2];
                String deviceName = values[1];
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date purchaseDate = dateFormat.parse(values[2]);
                int count = Integer.parseInt(values[3]);
                String purchaseTypeName = values[4];

                Device device = DeviceLocalServiceUtil.fetchDeviceByName(serviceContext.getScopeGroupId(), deviceName);
                Employee employee = EmployeeLocalServiceUtil.fetchByFullName(serviceContext.getScopeGroupId(), firstName, lastName, patronymic);
                PurchaseType purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseTypeByName(serviceContext.getScopeGroupId(), purchaseTypeName);
                
                if (device == null) {
                    logger.error("Device with given name does not exist");
                    throw new DataFormatException("Device with given name does not exist " + deviceName);
                }

                if (employee == null) {
                    logger.error("Employee with given name does not exist");
                    throw new DataFormatException("Employee with given name does not exist " + firstName + lastName + patronymic);
                }

                if (purchaseType == null) {
                    logger.error("Purchase type with given name does not exist");
                    throw new DataFormatException("Purchase type with given name does not exist");
                }
                
                PurchaseLocalServiceUtil.addPurchase(employee.getEmployeeId(), device.getDeviceId(),
                        count, purchaseDate, purchaseType.getPurchaseTypeId(), serviceContext);
                logger.info("Purchase was saved");
            } catch (NumberFormatException | ParseException exception) {
                logger.error("Invalid param formatting");
                throw new DataFormatException("Error when parsing param values in the csv file");
            } catch (PortalException exception) {
                throw new DataFormatException("Values did not pass validation. Check if any of the values are empty.");
            }
        }
    }
}
