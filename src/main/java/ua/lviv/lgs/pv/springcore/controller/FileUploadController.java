package ua.lviv.lgs.pv.springcore.controller;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.pv.springcore.service.UserService;

import java.io.File;
import java.nio.file.Files;
import java.security.Principal;

@RestController
public class FileUploadController {

    private final UserService userService;

    public FileUploadController(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @PostMapping("/avatar")
    public void uploadAvatar(@RequestParam("file") MultipartFile multipartFile, Principal principal) {
        userService.uploadUserAvatar(principal.getName(), multipartFile.getBytes());
    }

    @SneakyThrows
    @GetMapping("/avatar")
    public byte [] loadAvatar(Principal principal) {
        byte[] userAvatar = userService.getUserAvatar(principal.getName());
        if (userAvatar == null) {
            File defaultLogoFile = new ClassPathResource("img/logo.png").getFile();
            userAvatar = Files.readAllBytes(defaultLogoFile.toPath());
        }
        return userAvatar;
    }
}
