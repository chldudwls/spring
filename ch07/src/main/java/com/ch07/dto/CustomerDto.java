package com.ch07.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String custid;
    private String name;
    private int age;
    private String hp;
    private String addr;
    private String regdate;

    private long orderCount;
}
