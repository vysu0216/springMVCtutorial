package com.vysu.controller;

import com.vysu.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomePageController {

    ProductCategoryService productCategoryService;

    @Autowired
    public HomePageController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("categories", productCategoryService.getAllCategoriesAsList());
        return "home";
    }

}
