package com.vysu.controller;

import com.vysu.service.ProductCategoryService;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.apache.tiles.preparer.ViewPreparer;


@Controller
public class ProductMenusController implements ViewPreparer {

    public ProductMenusController() {

    }

    ProductCategoryService productCategoryService;

    @Autowired
    public ProductMenusController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    public void execute(Request request, AttributeContext attributeContext) {
        attributeContext.putAttribute("headerMenu", new Attribute("This is the value added by the HeaderPreparer"), true);
    }
}

