package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.OrderEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;

import java.util.List;

public interface OrderRepositoryFacade {
    List<OrderEntity> findAll();
    OrderEntity findById(Long id);

    void create(OrderEntity order);
}
