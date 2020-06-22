package ua.lviv.lgs.pv.service;

import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.repository.BasketRepository;

import java.util.List;

public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;

    @Override
    public void addProductToBasket(Long productId, Integer productCount, Long basketId) {
        basketRepository.addProductToBasket(productId, productCount, basketId);
    }

    @Override
    public List<Product> findByBasketId(Long basketId) {
        return null;
    }

    @Override
    public int getProductsCountInBasket(Long basketId) {
        return 0;
    }
}
