package com.wz.testtask.estore.util;

import com.liferay.portal.kernel.service.ServiceContext;
import com.wz.testtask.estore.exception.DataFormatException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Transforms csv params String into actual parameters and decides which one of the services must be called.
 */
public interface CsvTableReader {
    boolean isSuitable(String fileName);
    
    void readCsvFile(ServiceContext serviceContext, BufferedReader reader) throws IOException, DataFormatException;
}
