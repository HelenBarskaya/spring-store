package com.example.mystore.controller;

import com.example.mystore.model.Category;
import com.example.mystore.model.Product;
import com.example.mystore.service.CategoryService;
import com.example.mystore.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/find")
public class ProductController {

    ProductService productService;
    CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/bycategory")
    public String searchByCategory(@RequestParam int id, Model model) throws Exception {
        Category category = categoryService.getCategoryById(id);
        List<Product> list = productService.getByCategoryId(id);

        if (!list.isEmpty()) {
            String nameCategory = category.getName();

            model.addAttribute("listProducts", list);
            model.addAttribute("nameCategory", nameCategory);
        } else {
            model.addAttribute("nameCategory",
                    "Похоже, по вашему запросу ничего не найдено :(");
        }

        return "result";
    }

    @GetMapping(path = "/bypattern")
    public String searchByPattern(@RequestParam String pattern, Model model) {
        String nameCategory = "Результаты поиска";

        List<Product> list = productService.getByPatternName(pattern);
        if (!list.isEmpty()) {
            model.addAttribute("listProducts", list);
            model.addAttribute("nameCategory", nameCategory);
        } else {
            model.addAttribute("nameCategory",
                    "Похоже, по вашему запросу ничего не найдено :(");
        }

        return "result";
    }

    @GetMapping(path = "/product")
    public String searchById(@RequestParam int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);

        return "product";
    }
}
