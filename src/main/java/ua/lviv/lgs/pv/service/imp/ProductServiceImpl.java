package ua.lviv.lgs.pv.service.imp;

import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.repository.ProductRepository;
import ua.lviv.lgs.pv.repository.impl.ProductRepositoryImpl;
import ua.lviv.lgs.pv.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private static ProductServiceImpl instantce;

    private ProductServiceImpl() {
        this.productRepository = ProductRepositoryImpl.getInstance();
    }

    public static ProductServiceImpl getInstantce(){
        if (instantce == null) {
            instantce = new ProductServiceImpl();
        }
        return instantce;
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return productRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        productRepository.deleteById(integer);
    }

}
