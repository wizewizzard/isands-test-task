package com.wz.testtask.estore.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.wz.testtask.estore.exception.DataFormatException;
import com.wz.testtask.estore.service.PurchaseTypeLocalServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;

public class PurchaseTypeCsvReader implements CsvTableReader {
    private static final Log logger = LogFactoryUtil.getLog(EmployeeCsvTableReader.class);
    
    @Override
    public boolean isSuitable(String fileName) {
        return fileName.toLowerCase().equals("ESTORE_PurchaseType.csv".toLowerCase());
    }
    
    @Override
    public void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException {
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                String[] values = line.split(",");
                if (values.length != 1) {
                    logger.error("Invalid params count in csv string. Excepted length is 1 but given: " + values.length);
                    throw new DataFormatException("Invalid params count in csv file string");
                }
                String name = values[0];
                PurchaseTypeLocalServiceUtil.addPurchaseType(name, serviceContext);
            } catch (PortalException exception) {
                throw new DataFormatException("Values did not pass validation. Check if any of the values are empty.", exception);
            }
        }
    }
}
