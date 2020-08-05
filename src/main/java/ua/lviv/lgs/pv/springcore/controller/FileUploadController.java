package ua.lviv.lgs.pv.springcore.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @PostMapping("/avatar")
    public void uploadAvatar(MultipartFile multipartFile) {

    }
}
