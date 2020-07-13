package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.pv.springcore.entity.MoneyAccount;
import ua.lviv.lgs.pv.springcore.repository.MoneyAccountRepository;
import ua.lviv.lgs.pv.springcore.service.CurrencyService;
import ua.lviv.lgs.pv.springcore.service.MoneyAccountService;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class MoneyAccountServiceImpl implements MoneyAccountService {

    private final MoneyAccountRepository moneyAccountRepository;
    private final CurrencyService currencyService;

    public MoneyAccountServiceImpl(MoneyAccountRepository moneyAccountRepository, CurrencyService currencyService) {
        this.moneyAccountRepository = moneyAccountRepository;
        this.currencyService = currencyService;
    }

    @Override
    public MoneyAccount createDefault() {
        MoneyAccount moneyAccount = new MoneyAccount();
        moneyAccount.setInitialBalance(new BigDecimal(0));
        moneyAccount.setInitialDate(Instant.now());
        moneyAccount.setName("Default");
        moneyAccount.setCurrency(currencyService.createDefault());
        return moneyAccountRepository.save(moneyAccount);
    }

}
