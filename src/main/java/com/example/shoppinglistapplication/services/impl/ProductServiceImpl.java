package com.example.shoppinglistapplication.services.impl;

import com.example.shoppinglistapplication.models.entities.Product;
import com.example.shoppinglistapplication.models.service.ProductServiceModel;
import com.example.shoppinglistapplication.repositories.ProductRepository;
import com.example.shoppinglistapplication.services.CategoryService;
import com.example.shoppinglistapplication.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {

        return productRepository.findTotalProductsSum();
    }
}
