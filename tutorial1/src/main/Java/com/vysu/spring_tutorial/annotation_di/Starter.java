package com.vysu.spring_tutorial.annotation_di;

import com.vysu.store.model.DAO.CategoryDAO;
import com.vysu.store.model.DAO.ProductDAO;
import com.vysu.store.model.entity.Category;
import com.vysu.store.model.entity.Product;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class Starter {

    static private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    static private ProductDAO productDAO = (ProductDAO) context.getBean("productDAOImpl");
    static private CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAOImpl");

    public static Category createCategory(String name,Boolean isTop,Category parent) {
        Category category = new Category(name);
        category.setIsTopLevel(isTop);
        category.setParentCategory(parent);
        categoryDAO.addCategory(category);
        return category;
    }

    private static Product createProduct(String name, BigDecimal price){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    public static void main(String[] args) {

        Product iPhone = createProduct("iPhone", new BigDecimal("15.500"));
        Product s8 = createProduct("Galaxy s8", new BigDecimal("10.500"));
        Product tabletPc = createProduct("iPad", new BigDecimal("20.20"));



        Category tablets;
        Category phones;
        Category apple = categoryDAO.getCategoryById(10);
        Category samsung;

        iPhone.setCategory(apple);
        productDAO.addProduct(iPhone);

/*
        tablets=createCategory("Tablets",true,null);
        phones = createCategory("Phones",true,null);
        apple = createCategory("Apple",false,phones);
        samsung = createCategory("Samsung",false,phones);
*/


    }
}