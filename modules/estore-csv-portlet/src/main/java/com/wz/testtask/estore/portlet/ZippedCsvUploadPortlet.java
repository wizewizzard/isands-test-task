package com.wz.testtask.estore.portlet;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.wz.testtask.estore.constants.ZippedCsvUploadPortletKeys;
import com.wz.testtask.estore.exception.DataFormatException;
import com.wz.testtask.estore.exception.FileReadException;
import com.wz.testtask.estore.exception.TableNotFoundException;
import com.wz.testtask.estore.util.*;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author aleksei
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=ZippedCsvUpload",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + ZippedCsvUploadPortletKeys.ZIPPEDCSVUPLOAD,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class ZippedCsvUploadPortlet extends MVCPortlet {
    /*
    private static String ROOT_FOLDER_NAME = PortletProps.get("fileupload.folder.name");
    private static String ROOT_FOLDER_DESCRIPTION = PortletProps.get("fileupload.folder.description");
    private static List<String> SUPPORTED_FORMATS = Arrays.asList(PortletProps.get("fileupload.supported-mime-types").split(","));
    */
    private static final long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
    private static final String ROOT_FOLDER_NAME = "unzipped_csvs";
    private static final String ROOT_FOLDER_DESCRIPTION = "Tmp *.csv files that were unzipped from an archive are located here";
    private static final List<String> SUPPORTED_FORMATS = Arrays.asList("application/zip".split(","));
    private static final Log logger = LogFactoryUtil.getLog(ZippedCsvUploadPortlet.class);
    
    private final List<CsvTableReader> tableReaders =
            Arrays.asList(
                    new DeviceTypeCsvTableReader(),
                    new EmployeePositionCsvTableReader(),
                    new PurchaseTypeCsvTableReader(),
                    new DeviceCsvTableReader(),
                    new EmployeeCsvTableReader(),
                    new PurchaseCsvTableReader()
                    );
    
    /* @Inject
    private List<CsvTableReader> tableReaders;*/
    
    public void uploadZippedCsvData(ActionRequest request, ActionResponse response) throws PortalException, IOException, PortletException {
        UploadPortletRequest uploadRequest = PortalUtil
                .getUploadPortletRequest(request);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        
        if (isSupported(uploadRequest)) {
            try {
                createFolder(request, themeDisplay);
                extractFiles(uploadRequest, themeDisplay, serviceContext);
                parseFileData(serviceContext, themeDisplay);
            } catch (FileReadException exception) {
                logger.error("Unable to read the file.", exception);
                SessionErrors.add(request, "cant-read-file");
            } catch (TableNotFoundException exception) {
                logger.error("Table was not found.", exception);
                SessionErrors.add(request, "table-not-found");
            } catch (DataFormatException exception) {
                logger.error("Data formatting is wrong.", exception);
                SessionErrors.add(request, "invalid-data-format");
            } catch (Exception exception) {
                logger.error("Portal exception fired.", exception);
                SessionErrors.add(request, "error");
            } finally {
                cleanUp(themeDisplay);
            }
        } else {
            logger.error("Unsupported format of file");
            SessionErrors.add(request, "unsupported-file-format");
        }
    }
    
    protected boolean isSupported(UploadPortletRequest uploadRequest) {
        String mimeType = uploadRequest.getContentType("uploadedFile");
        logger.info(String.format("File mime type is %s, ", mimeType));
        return SUPPORTED_FORMATS.contains(mimeType);
    }
    
    protected void extractFiles(UploadPortletRequest uploadRequest,
                                ThemeDisplay themeDisplay,
                                ServiceContext serviceContext) throws PortalException, FileReadException {
        logger.trace("Extracting files from archive");
        File zipFile = uploadRequest.getFile("uploadedFile");
        String mimeType = uploadRequest.getContentType("uploadedFile");
        long repositoryId = themeDisplay.getScopeGroupId();
        
        try (ZipInputStream zipInputStream = new ZipInputStream((new FileInputStream(zipFile)))) {
            Folder folder = getFolder(themeDisplay);
            
            ZipEntry zipEntry;
            byte[] buffer = new byte[2048];
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                System.out.format("File: %s Size: %d last modified %s\n",
                        zipEntry.getName(), zipEntry.getSize(),
                        LocalDate.ofEpochDay(zipEntry.getTime() / 86400000L));
                
                try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                     BufferedOutputStream bos = new BufferedOutputStream(outputStream, buffer.length)) {
                    
                    int len;
                    while ((len = zipInputStream.read(buffer)) > 0) {
                        bos.write(buffer, 0, len);
                    }
                    bos.flush();
                    String fileName = zipEntry.getName();
                    if (fileName.endsWith(".csv")) {
                        logger.info("Saving file");
                        try {
                            DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), fileName);
                            DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, folder.getFolderId(), fileName);
                        } catch (PortalException ignored) {
                        
                        }
                        
                        DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, "text/csv",
                                fileName, "tmp file", "", new ByteArrayInputStream(outputStream.toByteArray()),
                                zipEntry.getSize(), serviceContext);
                        logger.info("File was saved");
                    } else {
                        logger.warn("Unsupported file type in archive. Skipping it");
                    }
                }
            }
        } catch (IOException exception) {
            logger.error("Error when uploading a file");
            //TODO: throw new Portal exception
            throw new FileReadException("Can not read archive file", exception);
        }
    }
    
    protected Folder getFolder(ThemeDisplay themeDisplay) throws PortalException {
        Folder folder = null;
        folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
        return folder;
    }
    
    protected void parseFileData(ServiceContext serviceContext,
                                 ThemeDisplay themeDisplay)
            throws FileReadException, TableNotFoundException, DataFormatException, PortalException {
        logger.trace("Parsing csv files");
        long repositoryId = themeDisplay.getScopeGroupId();
        Folder folder = getFolder(themeDisplay);
        List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
        
        //table readers are ordered from secondary tables that must be populated first to primary ones, which depend on secondary
        for(CsvTableReader tableReader : tableReaders){
            for (FileEntry fileEntry : fileEntries){
                if(tableReader.isSuitable(fileEntry.getFileName())){
                    try(BufferedReader br = new BufferedReader(
                            new InputStreamReader(fileEntry.getContentStream(), UTF_8))){
                        tableReader.readCsvFile(serviceContext, br);
                    }
                    catch (IOException exception) {
                        logger.error("Error reading file", exception);
                        throw new FileReadException("Error reading file", exception);
                    }
                }
            }
        }
        
        /*for (FileEntry fileEntry : fileEntries) {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(fileEntry.getContentStream(), UTF_8))) {
                CsvTableReader reader = tableReaders.stream()
                        .filter(r -> r.isSuitable(fileEntry.getFileName()))
                        .findFirst()
                        .orElseThrow(() ->
                                new TableNotFoundException("Table with name "
                                        + fileEntry.getFileName() + " can not be read")
                        );
                reader.readCsvFile(serviceContext, br);
            } catch (IOException exception) {
                logger.error("Error reading file", exception);
                throw new FileReadException("Error reading file", exception);
            }
        }*/
    }
    
    protected void cleanUp(ThemeDisplay themeDisplay) {
        logger.info("Cleaning up the files");
        long repositoryId = themeDisplay.getScopeGroupId();
        try {
            Folder folder = getFolder(themeDisplay);
            List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
            for (FileEntry fileEntry : fileEntries) {
                logger.info("Deleting " + fileEntry.getFileName());
                try {
                    DLAppServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
                } catch (Exception exception) {
                    logger.warn("File entry was not deleted: " + fileEntry.getFileName(), exception);
                }
            }
        } catch (Exception exception) {
            logger.error("Error when cleaning up the files", exception);
        }
        logger.info("Files were cleaned");
    }
    
    protected Folder createFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay) throws PortalException {
        boolean folderExist = isFolderExist(themeDisplay);
        Folder folder = null;
        if (!folderExist) {
            long repositoryId = themeDisplay.getScopeGroupId();
            logger.info("Creating folder for " + repositoryId);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
            folder = DLAppServiceUtil.addFolder(repositoryId, PARENT_FOLDER_ID, ROOT_FOLDER_NAME, ROOT_FOLDER_DESCRIPTION, serviceContext);
        }
        return folder;
    }
    
    protected boolean isFolderExist(ThemeDisplay themeDisplay) {
        boolean folderExist = false;
        try {
            DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
            folderExist = true;
            logger.info("Folder already exists");
        } catch (Exception ignored) {
        
        }
        return folderExist;
    }
}