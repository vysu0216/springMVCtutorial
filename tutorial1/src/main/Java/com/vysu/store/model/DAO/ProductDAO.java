package com.vysu.store.model.DAO;

public interface ProductDAO {

    void addProduct(Product product);

    Product getProductById(long id);

    void saveProduct(Product product);
}