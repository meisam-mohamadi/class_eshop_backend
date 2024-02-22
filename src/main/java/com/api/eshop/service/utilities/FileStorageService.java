package com.api.eshop.service.utilities;

import com.api.eshop.domain.utilities.FileUploadResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path fileStoragePath;
    private final String fileStorageLocation;

    public FileStorageService(@Value("${file.storage.location:temp}") String fileStorageLocation) {
        this.fileStorageLocation = fileStorageLocation;
        fileStoragePath = Paths.get(fileStorageLocation).toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory",e);
        }
    }

    public FileUploadResponse storeFile(MultipartFile file) {


        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String today = dateFormat.format(date);

        File ff = new File(fileStorageLocation + "/" + today);
        if (!ff.exists()) {
            ff.mkdir();
        }

        File f = new File(fileStorageLocation + "/" + today + "/" + currentUser.replace("\"", "")); //for mac server
        if (!f.exists()) {
            f.mkdir();
        }


        Path path = Paths.get(fileStorageLocation+"\\"+today);


        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(fileName);

        String fileUUID = UUID.randomUUID().toString();
       //for windows
        // Path filePath = Paths.get(fileStoragePath + "\\" + today + "\\" + currentUser.replace("\\", "") + "/" + fileUUID + "__________" + fileName);

    //for mac os
        Path filePath = Paths.get(fileStoragePath + "/" + today + "/" + currentUser.replace("/", "") + "/" + fileUUID + "__________" + fileName);

        try {
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Issue in storing the file", e);
        }
        fileName = fileUUID + "__________" + fileName;


        String url = "/Files/Download/" + SecurityContextHolder.getContext().getAuthentication().getName() + "/" + today + "/" + fileName;
        String contentType = file.getContentType();
        FileUploadResponse response = new FileUploadResponse(fileName, contentType, url, today);
        return response;

    }

    public Resource downloadFile(String fileName , String owner , String date)
    {
        Path path =  Paths.get(fileStorageLocation+"/"+date+"/"+owner).toAbsolutePath().resolve(fileName);
        Resource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Issue in Reading the file" , e);
        }
        if (resource.exists() && resource.isReadable()){
            return  resource;
        } else
        {
            throw new RuntimeException("the file does not exist or not readable");
        }

    }
}
