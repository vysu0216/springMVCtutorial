package com.vysu.controller;

import com.vysu.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CategoryController {

    ProductCategoryService productCategoryService;

    @Autowired
    public CategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String showHomePage(@RequestParam("cat_id") long categoryId, Map<String, Object> model) {

        return "category";
    }

}
