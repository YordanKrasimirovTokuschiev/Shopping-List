package com.example.shoppinglistapplication.services;

import com.example.shoppinglistapplication.models.entities.Category;
import com.example.shoppinglistapplication.models.entities.CategoryName;

public interface CategoryService {
    void initCategoriesName();

    Category findByName(CategoryName categoryName);
}
