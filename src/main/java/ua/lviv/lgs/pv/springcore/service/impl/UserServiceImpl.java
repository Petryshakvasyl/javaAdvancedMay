package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.pv.springcore.dto.UserDTO;
import ua.lviv.lgs.pv.springcore.entity.MoneyAccount;
import ua.lviv.lgs.pv.springcore.entity.Role;
import ua.lviv.lgs.pv.springcore.entity.User;
import ua.lviv.lgs.pv.springcore.error.ResourceNotFoundException;
import ua.lviv.lgs.pv.springcore.repository.RoleRepository;
import ua.lviv.lgs.pv.springcore.repository.UserRepository;
import ua.lviv.lgs.pv.springcore.service.MoneyAccountService;
import ua.lviv.lgs.pv.springcore.service.UserService;
import ua.lviv.lgs.pv.springcore.service.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MoneyAccountService moneyAccountService;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, MoneyAccountService moneyAccountService, RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.moneyAccountService = moneyAccountService;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() ->
                new ResourceNotFoundException("not found role ROLE_USER"));
        user.getRoles().add(role);
//        user.setPassword(encoder.encode(user.getPassword()));
        MoneyAccount defaultMoneyAccount = moneyAccountService.createDefault();
        user.setCurrentAccount(defaultMoneyAccount);
        user.getMoneyAccounts().add(defaultMoneyAccount);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO findByUserName(String username) {
        return userMapper.toDto(userRepository.findByUsername(username).orElseThrow(() ->
                new ResourceNotFoundException("not found user with username: " + username)));
    }
}
