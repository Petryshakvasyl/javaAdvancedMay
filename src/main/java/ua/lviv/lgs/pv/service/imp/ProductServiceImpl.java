package ua.lviv.lgs.pv.service.imp;

import ua.lviv.lgs.pv.entity.Product;
import ua.lviv.lgs.pv.repository.ProductRepository;
import ua.lviv.lgs.pv.repository.ProductRepositoryImpl;
import ua.lviv.lgs.pv.service.ProductService;

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

}
