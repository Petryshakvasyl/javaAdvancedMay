package ua.lviv.lgs.service;

public class UserService {

    public String getAdminName() {
        return "Admin";
    }

    public void notFoundUserWithId(Long id) {
        throw new UserNotFoundException(id);
    }

}

class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with id " + id +" not found");
    }
}
