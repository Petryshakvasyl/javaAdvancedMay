package ua.lviv.lgs.pv.springcore.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.lgs.pv.springcore.entity.Currency;
import ua.lviv.lgs.pv.springcore.repository.CurrencyRepository;
import ua.lviv.lgs.pv.springcore.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency createDefault() {
        Currency currency = new Currency();
        currency.setCode("UAH");
        currency.setName("Ukrainian hryvna");
        return currencyRepository.save(currency);
    }

}
