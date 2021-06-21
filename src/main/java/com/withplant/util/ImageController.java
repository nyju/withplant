package com.withplant.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class ImageController {

    @Value("${attachement.repository}")
    private String repository;

    @GetMapping(value = "/image/view", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getImage(@RequestParam("path") String path)
            throws IOException {
        System.out.println("/image/view");
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //String fileDir = path; // 파일경로
        String fileDir = Paths.get(repository, path).toString();

        try {
            fis = new FileInputStream(fileDir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int readCount = 0;
        byte[] buffer = new byte[1024];
        byte[] fileArray = null;

        try {
            while ((readCount = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, readCount);
            }
            fileArray = baos.toByteArray();
            fis.close();
            baos.close();
        } catch (IOException e) {
            throw new RuntimeException("File Error");
        }
        return fileArray;
    }
}
