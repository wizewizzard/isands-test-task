package com.wz.testtask.estore.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.wz.testtask.estore.exception.DataFormatException;
import com.wz.testtask.estore.model.DeviceType;
import com.wz.testtask.estore.service.DeviceLocalServiceUtil;
import com.wz.testtask.estore.service.DeviceTypeLocalServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;

public class DeviceCsvTableReader implements CsvTableReader {
    private static final Log logger = LogFactoryUtil.getLog(EmployeeCsvTableReader.class);
    
    @Override
    public boolean isSuitable(String fileName) {
        return fileName.toLowerCase().equals("ESTORE_Device.csv".toLowerCase());
    }
    
    @Override
    public void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException {
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                String[] values = line.split(",");
                if (values.length != 7) {
                    logger.error("Invalid params count in csv string. Excepted length is 7 but given: " + values.length);
                    throw new DataFormatException("Invalid params count in csv file string");
                }
                String name = values[0];
                long price = Long.parseLong(values[1]);
                //long deviceTypeId = Long.parseLong(values[2]);
                String deviceTypeName = values[2];
                int count = Integer.parseInt(values[3]);
                boolean isStock = Boolean.parseBoolean(values[4]);
                boolean archive = Boolean.parseBoolean(values[5]);
                String description = values[6];
                DeviceType deviceType = DeviceTypeLocalServiceUtil.getDeviceTypeByName(serviceContext.getScopeGroupId(), deviceTypeName);
                if (deviceType == null) {
                    logger.error("Device type with given name does not exist");
                    throw new DataFormatException("Device type with given name does not exist");
                }
                DeviceLocalServiceUtil.addDevice(name, price, deviceType.getDeviceTypeId(), count, isStock, archive, description, serviceContext);
                
            } catch (NumberFormatException exception) {
                logger.error("Invalid param formatting");
                throw new DataFormatException("Error when parsing param values in the csv file", exception);
            } catch (PortalException exception) {
                throw new DataFormatException("Values did not pass validation. Check if any of the values are empty.", exception);
            }
        }
    }
}
