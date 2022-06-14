package com.example.shoppinglistapplication.services;

import com.example.shoppinglistapplication.models.service.ProductServiceModel;

import java.math.BigDecimal;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();


}
