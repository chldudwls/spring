package com.ch07.repository.shop;

import com.ch07.dto.CustomerDto;
import com.ch07.dto.ProductAggDto;
import com.ch07.entity.shop.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopQueryDslTest {

    /*
        QueryDSL 설정
         1) 의존성
         implementation 'com.querydsl:querydsl-jpa:5.1.0:jakarta'
         annotationProcessor "com.querydsl:querydsl-apt:5.1.0:jakarta"
         annotationProcessor "jakarta.annotation:jakarta.annotation-api"
         annotationProcessor "jakarta.persistence:jakarta.persistence-api"
         - build.gradle 파일 QueryDSL 경로 및 환경설정
         - Q도메인 클래스 생성 확인(애플리케이션이 실현 상태 확인)

         2) QueryDSL 구현
         - 개별 Repository 확장 Custom 인터페이스 생성
         - Custom 인터페이스를 구현하는 Impl 클래스 생성
         - Impl 클래스에서 QueryDSL 쿼리메서드 정의
         - 개별 Repository에 Custom 인터페이스 상속 추가
         -
     */
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    private QCustomer qCustomer = QCustomer.customer;
    private QProduct qProduct = QProduct.product;
    private QOrder qOrder = QOrder.order;

    @Test
    void test01(){
    List<Product> products = jpaQueryFactory
                .selectFrom(qProduct)
                .fetch();
        System.out.println(products);
    }
    @Test
    void test02(){
        List<Product> products = jpaQueryFactory
                .select(
                        Projections.fields(
                                Product.class,
                                qProduct.productId,
                                qProduct.productName,
                                qProduct.price
                        )
                )
                .from(qProduct)
                .fetch(); //fetch 결과는 list
        System.out.println(products);
    }
    @Test
    void test03(){
        List<Customer> customers1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.eq("감자")).fetch();
        List<Customer> customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.ne("감자")).fetch();

        System.out.println(customers1);
        System.out.println(customers2);
    }
    @Test
    void test04(){
        List<Customer> customers1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(44)).fetch();
        List<Customer> customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(44)).fetch();
        List<Customer> customers3 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(44)).fetch();
        List<Customer> customers4 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(44)).fetch();

        System.out.println(customers1);
        System.out.println(customers2);
        System.out.println(customers3);
        System.out.println(customers4);
    }
    @Test
    void test05(){
        List<Customer> customers1 = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.addr.in("부산광역시", "김해"))
                .fetch();
        System.out.println(customers1);
    }
    @Test
    void test06() {
        List<Customer> customers1 = jpaQueryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.like("%자"))
                .fetch();
        System.out.println(customers1);

    }
    @Test
    void test07(){
    List<Product> products1 = jpaQueryFactory
            .selectFrom(qProduct)
            .where(qProduct.stock.gt(0))
            .orderBy(qProduct.price.desc())
            .fetch();

        System.out.println(products1);
    }
    @Test
    void test08(){
        List<Product> products1 = jpaQueryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.asc())
                .offset(0)
                .limit(3)
                .fetch();
        System.out.println(products1);
    }
    @Test
    void test09(){
        List<ProductAggDto> productAggDtos = jpaQueryFactory
                .select(
                        Projections.fields(
                         ProductAggDto.class,
                         qProduct.price.sum().as("priceSum"),
                         qProduct.price.avg().as("priceAvg"),
                         qProduct.price.max().as("priceMax"),
                         qProduct.price.min().as("priceMin")
                        )
                )
                .from(qProduct)
                .fetch();
        System.out.println(productAggDtos);
    }
    @Test
    void test10(){
        List<CustomerDto> customerDtos = jpaQueryFactory
                .select(
                        Projections.fields(
                                CustomerDto.class,
                                qOrder.customer.custId,
                                qOrder.customer.name,
                                qOrder.customer.custId.count().as("orderCount")
                        )
                )
                .from(qOrder)
                .where(qOrder.orderStatus.eq(1))
                .groupBy(qOrder.customer.custId)
                .having(qOrder.customer.custId.count().goe(2))
                .fetch();
        System.out.println(customerDtos);
    }
    @Transactional
    @Test
    void test11(){
        List<Tuple> result = jpaQueryFactory
                .select(qOrder, qCustomer)
                .from(qOrder)
                .join(qCustomer)
                .on(qOrder.customer.eq(qCustomer))
                .fetch();
        System.out.println(result);
    }
    @Test
    void test12(){

    }
    @Test
    void test13(){

    }
}
