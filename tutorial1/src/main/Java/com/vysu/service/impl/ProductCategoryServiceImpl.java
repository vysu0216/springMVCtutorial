package com.vysu.service.impl;

import com.vysu.service.ProductCategoryService;
import com.vysu.store.model.DAO.CategoryDAO;
import com.vysu.store.model.entity.Category;
import com.vysu.store.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveProductCategory(String name, Category parentCat, Boolean isTopLevelCat) {
        Category category = new Category(name);
        category.setIsTopLevel(isTopLevelCat);
        category.setParentCategory(parentCat);
        categoryDAO.addCategory(category);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Category> getAllCategoriesAsList(){
        return categoryDAO.getAllCategories();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Category> getRootCategoriesAsList() {
        return categoryDAO.getRootCategories();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Category getProductCategoryById(long id) {
        return categoryDAO.getCategoryById(id);
    }

    public Category getProductCategoriesByName(String name) {
        return null;
    }

}