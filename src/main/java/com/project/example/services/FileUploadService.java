package com.project.example.services;

import com.google.cloud.storage.StorageException;
import com.project.example.entity.FileUpload;
import com.project.example.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class FileUploadService {
    @Autowired
    private FileUploadRepository fileUploadRepository;


    public FileUpload store(MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileUpload fileUpload = new FileUpload(fileName, file.getContentType(), file.getBytes());
        return fileUploadRepository.save(fileUpload);
    }

    public FileUpload getFile(String id) {
        return fileUploadRepository.findById(id).get();
    }

    public Stream<FileUpload> getAllFiles() {
        return fileUploadRepository.findAll().stream();
    }

    @Value("${upload.path}")
    private String path;
    public void uploadFile(MultipartFile file) throws Exception {

        if (file.isEmpty()) {

            //throw new StorageException("Failed to store empty file");
        }

        try {
            String fileName = file.getOriginalFilename();
            InputStream is = file.getInputStream();

            Files.copy(is, Paths.get(path + fileName),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {

            String msg = String.format("Failed to store file %f", file.getName());

            throw new Exception(msg, e);
        }
    }

}

