package com.project.example.controller;

import com.project.example.entity.FileUpload;
import com.project.example.message.ResponseFile;
import com.project.example.message.ResponseMessage;
import com.project.example.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> fileUpload(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileUploadService.store(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }


    @PostMapping("/upload1")
    public ResponseEntity<ResponseMessage> fileUpload1(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileUploadService.uploadFile(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }


    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileUploadService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getFId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getFName(),
                    fileDownloadUri,
                    dbFile.getFType(),
                    dbFile.getFData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

  /* @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(
                                        @PathVariable String fId) {
        System.out.println(fId);
       FileUpload fileUpload = fileUploadService.getFile(fId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileUpload.getFName() + "\"")
                .body(fileUpload.getFData());
    }*/


    @GetMapping("/files/{id}")
    public FileUpload getFile1(
            @PathVariable String fId) {
        System.out.println(fId);
      return fileUploadService.getFile(fId);


    }

}
