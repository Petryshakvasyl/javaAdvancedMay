package ua.lviv.lgs.pv.service;

import ua.lviv.lgs.pv.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void create(Product product);

    void update(Product product);

    List<Product> findAll();

    Optional<Product> findById(Integer integer);

    void deleteById(Integer integer);
}
