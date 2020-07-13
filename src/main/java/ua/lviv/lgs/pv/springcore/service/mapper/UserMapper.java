package ua.lviv.lgs.pv.springcore.service.mapper;

import org.mapstruct.Mapper;
import ua.lviv.lgs.pv.springcore.dto.UserDTO;
import ua.lviv.lgs.pv.springcore.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
}
