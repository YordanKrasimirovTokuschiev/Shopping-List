package com.example.shoppinglistapplication.services.impl;

import com.example.shoppinglistapplication.models.entities.Category;
import com.example.shoppinglistapplication.models.entities.CategoryName;
import com.example.shoppinglistapplication.repositories.CategoryRepository;
import com.example.shoppinglistapplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategoriesName() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category(categoryName, "Description for " + categoryName);

                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByName(CategoryName categoryName) {

        return categoryRepository
                .findByName(categoryName)
                .orElse(null);
    }
}
