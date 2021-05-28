package com.motagifarming.grapesmarket.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private int id;

    private String category;

    private String productName;

    private BigDecimal rate;

    private boolean avaiable;

}
