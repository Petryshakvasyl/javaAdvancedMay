package ua.lviv.lgs.pv.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.pv.springcore.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
