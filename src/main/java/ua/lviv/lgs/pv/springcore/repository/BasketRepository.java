package ua.lviv.lgs.pv.springcore.repository;


import ua.lviv.lgs.pv.springcore.entity.Bucket;

import java.util.List;

public interface BasketRepository {

    List<Bucket> findAll();
}
