package ua.lviv.lgs.pv.springcore.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.userdetails.UserDetails;
import ua.lviv.lgs.pv.springcore.dto.UserDTO;
import ua.lviv.lgs.pv.springcore.entity.User;
import ua.lviv.lgs.pv.springcore.entity.UserDetailsImpl;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);

    @Mapping(target = "enabled", source = "isEnabled")
    UserDetailsImpl toUserDetails(User user, boolean isEnabled);
}
