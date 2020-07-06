package ua.lviv.lgs.pv.springcore.repository.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.pv.springcore.entity.Bucket;
import ua.lviv.lgs.pv.springcore.repository.BasketRepository;

import java.util.List;
import java.util.Random;

@Repository
@Scope("prototype")
public class BasketRepositoryFakeImpl implements BasketRepository {
    private int randomValue = 100 + new Random().nextInt(200);

    @Override
    public List<Bucket> findAll() {
        System.out.println("call basket find all from fake basket repository" + randomValue);
        return null;
    }

}
