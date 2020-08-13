package com.harry.Audio_Forum.mapping;

import com.harry.Audio_Forum.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class Files {

    private FileUploadService fileUploadService;

    @Autowired
    public Files(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
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

    @GetMapping("/api/res")
    public Resource getResource2() throws IOException {
        return new Resource(new FileInputStream("F:\\spring\\file.jpg").readAllBytes(), "jpg");
    }

    private class Resource {
        private byte[] inputStream;
        private String type;

        public Resource(byte[] inputStream, String type) {
            this.inputStream = inputStream;
            this.type = type;
        }

        public byte[] getInputStream() {
            return inputStream;
        }

        public void setInputStream(byte[] inputStream) {
            this.inputStream = inputStream;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
