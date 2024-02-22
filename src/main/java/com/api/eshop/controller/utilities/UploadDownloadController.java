package com.api.eshop.controller.utilities;

import com.api.eshop.domain.utilities.FileUploadResponse;
import com.api.eshop.service.utilities.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class UploadDownloadController {

    @Autowired
    private FileStorageService fileStorageService;

//    @PostMapping("public/single/upload")
//    @CrossOrigin("*")
//    FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
//
//        String fileName = fileStorageService.storeFile(file);
//        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download").path(fileName).toUriString();
//        String contentType = file.getContentType();
//
//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
//        String today = dateFormat.format(date);
//
//        FileUploadResponse response = new FileUploadResponse(fileName, contentType, url, today);
//        return response;
//    }

    @GetMapping("Files/Download/{owner}/{date}/{fileName}")
    ResponseEntity<Resource> downloadSingleFile(@PathVariable String fileName,@PathVariable String owner,@PathVariable String date, HttpServletRequest request) {
        Resource resource = fileStorageService.downloadFile(fileName , owner , date);

        String mimeType;
        try {
            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
       return   ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType)).header(HttpHeaders.CONTENT_DISPOSITION , "attachment;fileName="+resource.getFilename()).body(resource);
      //  return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType)).header(HttpHeaders.CONTENT_DISPOSITION, "inline;fileName=" + resource.getFilename()).body(resource); // agar khatte bala ra uncomment konim ax ra browser download mikonad amma ba in khat dar khode browser render mikonad va namaieh midahad
    }
}
