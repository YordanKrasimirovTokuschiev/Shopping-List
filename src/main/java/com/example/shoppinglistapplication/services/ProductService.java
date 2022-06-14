package com.example.shoppinglistapplication.services;

import com.example.shoppinglistapplication.models.entities.CategoryName;
import com.example.shoppinglistapplication.models.service.ProductServiceModel;
import com.example.shoppinglistapplication.models.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryNAme(CategoryName categoryName);

    void buyById(Long id);

    void buyAll();
}
