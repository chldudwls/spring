package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.QOrder;
import com.ch07.repository.shop.Custom.OrderRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private QOrder qorder = QOrder.order;
    @Override
    public List<Order> selectOrders() {
        return queryFactory
                .select(qorder)
                .from(qorder)
                .fetch();
    }

    @Override
    public Order selectOrder(int orderId) {
        return queryFactory
                .select(qorder)
                .where(qorder.orderId.eq(orderId))
                .fetchOne();
    }

    @Override
    public List<Order> selectProjectionOrder() {
        return List.of();
    }

    @Override
    public List<Order> searchOrder(int orderidCondition, int orderPricecondition) {
        BooleanBuilder builder = new BooleanBuilder();
        if(orderidCondition!=0){
            builder.and(qorder.orderId.eq(orderidCondition));
        }
        if(orderPricecondition!=0){
            builder.and(qorder.orderPrice.eq(orderPricecondition));
        }
        return queryFactory
                .selectFrom(qorder)
                .where(builder)
                .fetch();


    }

    @Override
    public List<Order> searchOrder(String keyword) {
        BooleanExpression express = qorder.orderPrice.stringValue().containsIgnoreCase(keyword)
                .or(qorder.customer.addr.containsIgnoreCase(keyword));
        return queryFactory
                .selectFrom(qorder)
                .where(express)
                .fetch();
    }
}
