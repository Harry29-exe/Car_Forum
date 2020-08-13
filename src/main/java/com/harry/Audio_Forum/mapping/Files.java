package com.harry.Audio_Forum.mapping;

import com.harry.Audio_Forum.FileUploadService;
import com.harry.Audio_Forum.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.http.HttpHeaders;

@RestController
public class Files {

    private FileUploadService fileUploadService;
    private final StorageService storageService;


    @Autowired
    public Files(FileUploadService fileUploadService, StorageService storageService) {
        this.fileUploadService = fileUploadService;
        this.storageService = storageService;
    }

    @PostMapping("/api/resources")
    public void addResource(@RequestParam("file") MultipartFile file) throws IOException {
        fileUploadService.uploadFile(file);
    }

    @GetMapping(
            value = "/api/resources",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getResource() throws IOException {
        InputStream in = new FileInputStream("F:\\spring\\file.jpg");
        return in.readAllBytes();
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
