package ua.lviv.lgs.pv.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.lgs.pv.springcore.dto.UserDTO;
import ua.lviv.lgs.pv.springcore.service.UserService;

import java.security.Principal;

@Controller
public class ProfileController {

  private final UserService userService;

  public ProfileController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/profile")
  public String getProfilePage(ModelMap modelMap, Principal principal) {
    UserDTO user = userService.findByUserName(principal.getName());
    modelMap.addAttribute("user", user);
    return "profile";
  }
}
