package com.store.goat.controller;

import com.store.goat.dao.Category;
import com.store.goat.dao.CategoryRepository;
import com.store.goat.dao.Product;
import com.store.goat.model.CategoryModel;
import com.store.goat.dao.ProductRepository;
import com.store.goat.model.ProductModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/admin")
    public String adminHome() {
        return "admin";
    }

    @GetMapping("/admin/category")
    public String adminCategory(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "category";
    }

    /**
     * adds product to product table
     * @param model model to be gotten
     * @return product
     */
    @GetMapping("/admin/product")
    public String adminProduct(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product";
    }
    @GetMapping("/admin/category/addcategory")
    public String adminAddCategory(CategoryModel categoryModel) {
        return "addcategory";
    }
    @PostMapping("/admin/category/addcategory")
    public String adminAddCategorySubmit(@Valid CategoryModel categoryModel, BindingResult errors) {
        if (errors.hasErrors()) return "addcategory";
        Category category = new Category();
        category.setName(categoryModel.getName());
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }
    @GetMapping("/admin/product/addproduct")
    public String adminAddProduct(ProductModel productModel) {
        return "addproduct";
    }
    @PostMapping("/admin/product/addproduct")
    public String adminAddProductSubmit(@Valid ProductModel productModel, BindingResult errors) {
        if (errors.hasErrors()) return "addproduct";
        Product product = new Product();
        product.setName(productModel.getName());
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());
        product.setQuantity(productModel.getQuantity());
        product.setImage_url(productModel.getImageUrl());
        product.setCategory_id(productModel.getCategoryId());
        productRepository.save(product);
        return "redirect:/admin/product";
    }
}
