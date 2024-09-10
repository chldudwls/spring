package com.ch07.repository.shop.Custom;

import com.ch07.entity.shop.Customer;

import java.util.List;

// customerRepository 확장 인터페이스 설정
public interface CustomerRepositoryCustom {

    public List<Customer> selectCustomers();
    public Customer selectCustomer(String custId);
    public List<Customer> selectProjectionCustomer();
    public List<Customer> searchCustomer(String nameCondition, int ageCondition);
    public List<Customer> searchCustomer(String keyword);
}
