package com.dailycodebuffer.OrderService.service;


import com.dailycodebuffer.OrderService.entity.Order;
import com.dailycodebuffer.OrderService.model.OrderRequest;
import com.dailycodebuffer.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

    log.info("Placing Order Request: {}",orderRequest);
            Order order = Order.builder().amount(orderRequest.getTotalAmount())
                    .orderStatus("CREATED")
                    .productId((orderRequest.getProductId()))
                    .orderDate(Instant.now())
                    .quantity(orderRequest.getQuantity())
                    .build();

         order =   orderRepository.save(order);

        log.info("Order Places Sucessfully: {}",order.getId());

         return order.getId() ;
    }
}
