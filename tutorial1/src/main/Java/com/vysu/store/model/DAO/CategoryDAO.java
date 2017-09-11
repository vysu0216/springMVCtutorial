package com.vysu.store.model.DAO;

import com.vysu.store.model.entity.Category;

public interface CategoryDAO {

    void addCategory(Category category);

    Category getCategoryById(long id);

    void saveCategory(Category category);
}
