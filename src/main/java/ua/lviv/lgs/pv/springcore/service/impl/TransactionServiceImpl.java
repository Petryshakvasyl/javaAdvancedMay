package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.pv.springcore.dto.TransactionDTO;
import ua.lviv.lgs.pv.springcore.entity.Type;
import ua.lviv.lgs.pv.springcore.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TransactionDTO createInCurrentUserAccount(TransactionDTO transaction, Long userId) {
        return null;
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
        return null;
    }
}
