package com.vysu.spring_tutorial.annotation_di;

import com.vysu.service.ProductCategoryService;
import com.vysu.store.model.entity.Product;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class Starter {

    static private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-app-config.xml");
    static private ProductCategoryService productCategoryService = (ProductCategoryService) context.getBean("productCategoryServiceImpl");

    private static Product createProduct(String name, BigDecimal price){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    public static void main(String[] args) {

/*        Product iPhone = createProduct("iPhone", new BigDecimal("15.500"));
        Product s8 = createProduct("Galaxy s8", new BigDecimal("10.500"));
        Product tabletPc = createProduct("iPad", new BigDecimal("20.20"));*/

        productCategoryService.saveProductCategory("Tablets",null, true);
/*        Category phones = createCategory("Phones",true,null);
        Category apple = createCategory("Apple",false,phones);
        Category samsung = createCategory("Samsung",false,phones);*/

/*
        iPhone.setCategory(apple);
*/

    }
}