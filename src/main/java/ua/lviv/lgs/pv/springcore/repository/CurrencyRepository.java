package ua.lviv.lgs.pv.springcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.pv.springcore.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
