package com.vysu.store.model.DAO;

import com.vysu.store.model.entity.Category;

import java.util.List;

public interface CategoryDAO {

    void addCategory(Category category);

    Category getCategoryById(long id);

    void saveCategory(Category category);

    List<Category> getAllCategories();

    List<Category> getRootCategories();

}
