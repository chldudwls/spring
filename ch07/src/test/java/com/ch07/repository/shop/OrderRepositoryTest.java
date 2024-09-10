package com.ch07.repository.shop;



import com.ch07.entity.shop.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderRepositoryTest  {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void selectOrders(){
        List<Order> orders = orderRepository.selectOrders();
        System.out.println(orders);
    }

    @Test
    public void selectOrder(){
        Order order = orderRepository.selectOrder(1);
        System.out.println(order);
    }
    @Test
    public void searchOrder(){
        List<Order> orders1 = orderRepository.searchOrder(1, 3000);
        List<Order> orders2 = orderRepository.searchOrder(0,3000);
        List<Order> orders3 = orderRepository.searchOrder(1,0);
        List<Order> orders4 = orderRepository.searchOrder(0,0);

        System.out.println(orders1);
        System.out.println(orders2);
        System.out.println(orders3);
        System.out.println(orders4);
    }

    @Test
public void searchkeyword(){
        List<Order> orders1 = orderRepository.searchOrder("1");
        List<Order> orders2 = orderRepository.searchOrder("2");

        System.out.println(orders1);
        System.out.println(orders2);

    }
}
