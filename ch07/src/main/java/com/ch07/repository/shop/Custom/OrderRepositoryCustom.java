package com.ch07.repository.shop.Custom;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;

import java.util.List;

public interface OrderRepositoryCustom {

    public List<Order> selectOrders();
    public Order selectOrder(int orderId);
    public List<Order> selectProjectionOrder();
    public List<Order> searchOrder(int orderidCondition, int orderPricecondition);
    public List<Order> searchOrder(String keyword);
}
