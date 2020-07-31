package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.pv.springcore.dto.TransactionDTO;
import ua.lviv.lgs.pv.springcore.entity.*;
import ua.lviv.lgs.pv.springcore.error.ResourceNotFoundException;
import ua.lviv.lgs.pv.springcore.repository.CategoryRepository;
import ua.lviv.lgs.pv.springcore.repository.TransactionRepository;
import ua.lviv.lgs.pv.springcore.repository.UserRepository;
import ua.lviv.lgs.pv.springcore.service.TransactionService;
import ua.lviv.lgs.pv.springcore.service.mapper.TransactionMapper;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final UserRepository userRepository;

    private final TransactionMapper transactionMapper;

    private final CategoryRepository categoryRepository;

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(UserRepository userRepository,
                                  TransactionMapper transactionMapper,
                                  CategoryRepository categoryRepository,
                                  TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionMapper = transactionMapper;
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public TransactionDTO createInCurrentUserAccount(TransactionDTO transactionDTO, Long userId) {
        User currentUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
        MoneyAccount currentAccount = currentUser.getCurrentAccount();
        Transaction transaction = transactionMapper.toEntity(transactionDTO);
        Category category = categoryRepository.findById(transactionDTO.getCategoryId()).orElseThrow(() ->
                new ResourceNotFoundException(transactionDTO.getCategoryId()));
        transaction.setCategory(category);
        transaction.setMoneyAccount(currentAccount);
        return transactionMapper.toDTO(transactionRepository.save(transaction));
    }

    @Override
    public TransactionDTO findById(Long id) {
        return null;
    }

    @Override
    public Page<TransactionDTO> findByUserCurrentAccount(Long userId) {
        return null;
    }

    @Override
    public Page<TransactionDTO> findByUserCurrentAccountAndCategory(Long userId, Long categoryId) {
        return null;
    }

    @Override
    public TransactionDTO update(TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<TransactionDTO> findTypeForCurrentUser(Type type, Pageable pageable) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new ResourceNotFoundException(currentUsername));

        Long moneyAccountId = currentUser.getCurrentAccount().getId();
        return transactionRepository.findByTypeAndMoneyAccountId(type, moneyAccountId, pageable)
                .map(transactionMapper::toDTO);

    }
}
