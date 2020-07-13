package ua.lviv.lgs.pv.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.pv.springcore.entity.MoneyAccount;

public interface MoneyAccountRepository extends JpaRepository<MoneyAccount, Long> {
}
