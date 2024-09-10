package com.ch07.dto;

import lombok.Data;

@Data
public class ProductAggDto {
    private int priceSum;
    private double priceAvg;
    private int priceMax;
    private int priceMin;
}
