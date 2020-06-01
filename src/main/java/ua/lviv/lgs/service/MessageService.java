package ua.lviv.lgs.service;

public class MessageService {

    private UserService userService;

    public MessageService(UserService userService) {
        this.userService = userService;
    }

    public String generateDefaultMessage(){
        return "Hello";
    }

    public String generateMessageForAdmin(){
        String adminName = userService.getAdminName();
        return "Hello " + adminName;
    }

    public String generateMessageForUser(){
        String userName = userService.getUserName();
        return "Hello user " + userName;
    }

}
