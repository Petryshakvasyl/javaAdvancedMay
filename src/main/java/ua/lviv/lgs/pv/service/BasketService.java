package ua.lviv.lgs.pv.service;

import ua.lviv.lgs.pv.entity.Product;

import java.util.List;

public interface BasketService {

    void addProductToBasket(Long productId, Integer productCount, Long basketId);

    List<Product> findByBasketId(Long basketId);

    int getProductsCountInBasket(Long basketId);
}
