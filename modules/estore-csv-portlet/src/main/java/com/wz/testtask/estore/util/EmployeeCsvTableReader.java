package com.wz.testtask.estore.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.wz.testtask.estore.exception.DataFormatException;
import com.wz.testtask.estore.model.EmployeePosition;
import com.wz.testtask.estore.service.EmployeeLocalServiceUtil;
import com.wz.testtask.estore.service.EmployeePositionLocalServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeCsvTableReader implements CsvTableReader {
    private static final Log logger = LogFactoryUtil.getLog(EmployeeCsvTableReader.class);
    
    @Override
    public boolean isSuitable(String fileName) {
        return fileName.toLowerCase().equals("ESTORE_EMPLOYEE.csv".toLowerCase());
    }
    
    @Override
    public void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException {
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                String[] values = line.split(",");
                if (values.length != 6) {
                    logger.error("Invalid params count in csv string");
                    throw new DataFormatException("Invalid params count in csv file string");
                }
                String firstName = values[0];
                String lastName = values[1];
                String patronymic = values[2];
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date birthDate = dateFormat.parse(values[3]);
                String gender = values[4];
                String positionName = values[5];
                EmployeePosition employeePosition = EmployeePositionLocalServiceUtil.getEmployeePositionByName(serviceContext.getScopeGroupId(), positionName);
                if(employeePosition == null){
                    logger.error("Employee position with given name does not exist");
                    throw new DataFormatException("Employee position with given name does not exist");
                }
                EmployeeLocalServiceUtil.addEmployee(firstName, lastName, patronymic, birthDate, gender, employeePosition.getPositionId(), serviceContext);
            } catch (NumberFormatException | ParseException exception) {
                logger.error("Invalid param formatting");
                throw new DataFormatException("Error when parsing param values in the csv file");
            } catch (PortalException exception) {
                throw new DataFormatException("Values did not pass validation. Check if any of the values are empty.");
            }
        }
    }
}
