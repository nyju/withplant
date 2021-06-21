package com.withplant.attachment;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
public class AttachementController {

    private final String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
    //private final String uploadPath = Paths.get("C:", "Users", "ny", "dev", "IdeaProjects", "wpUpload", today).toString();

    @Value("${attachement.repository}")
    private String repository;

    private final String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @RequestMapping(value = "/upload")
    public void upload(HttpServletResponse response, HttpServletRequest request, @RequestParam("uploadFile") MultipartFile[] uploadFiles) throws IOException {
        String uploadPath = Paths.get(repository, today).toString();
        JSONArray arr = new JSONArray();

        for (MultipartFile uploadFile : uploadFiles) {

            File dir = new File(uploadPath);
            if (dir.exists() == false) {
                dir.mkdirs();
            }

            String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
            String saveName = getRandomString() + "." + extension;

            File target = new File(uploadPath, saveName);
            JSONObject obj = new JSONObject();

            uploadFile.transferTo(target);
            obj.put("path", today + "/" +saveName);
            obj.put("saveName", saveName);
            obj.put("fileName", uploadFile.getOriginalFilename());
            obj.put("size", uploadFile.getSize());

            arr.add(obj);
        }
        response.getWriter().write(arr.toJSONString());

    }
}
