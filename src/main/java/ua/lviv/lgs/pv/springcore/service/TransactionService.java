package ua.lviv.lgs.pv.springcore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.lviv.lgs.pv.springcore.dto.TransactionDTO;
import ua.lviv.lgs.pv.springcore.entity.Type;

public interface TransactionService {

    TransactionDTO createInCurrentUserAccount(TransactionDTO transaction, Long userId);

    TransactionDTO findById(Long id);

    Page<TransactionDTO> findByUserCurrentAccount(Long userId);

    Page<TransactionDTO> findByUserCurrentAccountAndCategory(Long userId, Long categoryId);

    TransactionDTO update(TransactionDTO transactionDTO);

    void deleteById(Long id);

    Page<TransactionDTO> findTypeForCurrentUser(Type type, Pageable pageable);
}
