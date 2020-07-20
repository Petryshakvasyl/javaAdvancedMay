package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.pv.springcore.dto.UserDTO;
import ua.lviv.lgs.pv.springcore.entity.MoneyAccount;
import ua.lviv.lgs.pv.springcore.entity.User;
import ua.lviv.lgs.pv.springcore.repository.UserRepository;
import ua.lviv.lgs.pv.springcore.service.MoneyAccountService;
import ua.lviv.lgs.pv.springcore.service.UserService;
import ua.lviv.lgs.pv.springcore.service.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MoneyAccountService moneyAccountService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, MoneyAccountService moneyAccountService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.moneyAccountService = moneyAccountService;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        MoneyAccount defaultMoneyAccount = moneyAccountService.createDefault();
        user.setCurrentAccount(defaultMoneyAccount);
        user.getMoneyAccounts().add(defaultMoneyAccount);
        return userMapper.toDto(userRepository.save(user));
    }
}
