package ua.lviv.lgs.pv.repository;


import ua.lviv.lgs.pv.entity.Bucket;
import ua.lviv.lgs.pv.entity.Product;

import java.util.List;

public interface BasketRepository extends CrudRepository<Bucket, Integer> {
    void addProductToBasket(Long productId, Integer productCount, Long basketId);

    List<Product> findByBasketId(Long basketId);

    int getProductsCountInBasket(Long basketId);
}
