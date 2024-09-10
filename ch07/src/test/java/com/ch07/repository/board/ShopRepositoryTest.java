package com.ch07.repository.board;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.OrderItem;
import com.ch07.entity.shop.Product;
import com.ch07.repository.shop.CustomerRepository;
import com.ch07.repository.shop.OrderItemRepository;
import com.ch07.repository.shop.OrderRepository;
import com.ch07.repository.shop.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopRepositoryTest {
    @Autowired private CustomerRepository customerRepository;
    @Autowired private OrderRepository orderRepository;
    @Autowired private OrderItemRepository orderItemRepository;
    @Autowired private ProductRepository productRepository;

    //고객등록
    @Test
    void insertCustomerTest() {
        Customer customer = Customer.builder()
                                    .custId("a123")
                                    .name("감자")
                                    .age(44)
                                    .hp("010-1212-2121")
                                    .addr("부산광역시")
                                    .build();
        customerRepository.save(customer);
    }

    // 상품등록
    @Test
    void insertProductTest() {
        Product product1 = Product.builder()
                .productName("홈런볼")
                .price(2000)
                .stock(10)
                .build();
        Product product2 = Product.builder()
                .productName("감자칩")
                .price(1000)
                .stock(120)
                .build();

        productRepository.save(product1);
        productRepository.save(product2);

    }

    //주문등록
    @Test
    void insertOrderTest() {
        Customer customer = Customer.builder()
                .custId("a123")
                .build();

        Product product1 = Product.builder().productId(1).build();
        Product product2 = Product.builder().productId(2).build();

        Order order = Order.builder()
                .customer(customer)
                .orderPrice(3000)
                .orderStatus(1)
                .build();
        orderRepository.save(order);
    }

    // 주문 아이템 등록
    @Test
    void insertOrderItemTest() {
        Order oder = Order.builder().orderId(1).build();
        Product product1 = Product.builder().productId(1).build();
        Product product2 = Product.builder().productId(2).build();

        OrderItem item1 = OrderItem.builder()
                .order(oder)
                .product(product1)
                .count(2)
                .build();
        OrderItem item2 = OrderItem.builder()
                .order(oder)
                .product(product2)
                .count(4)
                .build();
    }

    // 주문 조회
    @Transactional
    @Test
    void selectOrderTest() {
        List<Order> orders = orderRepository.findAll();
        System.out.println(orders);
    }
}
