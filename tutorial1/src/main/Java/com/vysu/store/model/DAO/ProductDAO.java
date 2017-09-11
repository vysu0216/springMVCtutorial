package com.vysu.store.model.DAO;

import com.vysu.store.model.entity.Product;

public interface ProductDAO {

    void addProduct(Product product);

    Product getProductById(long id);

    void saveProduct(Product product);
}