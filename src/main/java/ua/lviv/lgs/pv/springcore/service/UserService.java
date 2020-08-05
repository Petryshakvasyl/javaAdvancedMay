package ua.lviv.lgs.pv.springcore.service;

import ua.lviv.lgs.pv.springcore.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO user);

    UserDTO findByUserName(String name);

    byte[] getUserAvatar(String username);

    void uploadUserAvatar(String username, byte[] avatar);
}
