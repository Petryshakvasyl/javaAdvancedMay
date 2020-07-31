package ua.lviv.lgs.pv.springcore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.lviv.lgs.pv.springcore.entity.Transaction;
import ua.lviv.lgs.pv.springcore.entity.Type;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select t from Transaction t where t.type = ?1 and t.moneyAccount.id =?2")
    Page<Transaction> findByTypeAndMoneyAccountId(Type type, Long moneyAccountId, Pageable pageable);
}
