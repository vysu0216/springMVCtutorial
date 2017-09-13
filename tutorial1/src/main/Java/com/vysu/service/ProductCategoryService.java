package com.vysu.service;

import com.vysu.store.model.entity.Category;

import java.util.List;

public interface ProductCategoryService {

    void saveProductCategory(String name, Category parentCat, Boolean isTopLevelCat);

    Category getProductCategoryById(long id);

    Category getProductCategoriesByName(String name);

    List<Category> getAllCategoriesAsList();

}
