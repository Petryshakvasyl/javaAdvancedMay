package ua.lviv.lgs.pv.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping({"/home", "/"})
    public String hello() {
        return "home";
    }

}
