package com.desarrollo.complexivo_app.controllers;

import com.desarrollo.complexivo_app.models.Product;
import com.desarrollo.complexivo_app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/add-product")
    public String getFormProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/add-product";
    }
}
