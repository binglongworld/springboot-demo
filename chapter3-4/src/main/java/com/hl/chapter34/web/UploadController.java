package com.hl.chapter34.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Controller
public class UploadController {
    @Value("${file.upload.path}")
    private String path;

    @GetMapping(value = "/home")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public String create(@RequestPart MultipartFile[] files) throws IOException {
        File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
        if (!basePath.exists()) {
            basePath = new File("");
        }
        log.info("path: " + basePath.getAbsolutePath());
        File upload = new File(basePath.getAbsoluteFile(), path);
        if (!upload.exists()) {
            upload.mkdirs();
        }
        StringBuffer message = new StringBuffer();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            File dest = new File(upload.getAbsoluteFile() + "/" + fileName);

            Files.copy(file.getInputStream(), dest.toPath());
            message.append("Upload file success : " + dest.getAbsolutePath()).append("<br>");
        }

        return message.toString();
    }
}
