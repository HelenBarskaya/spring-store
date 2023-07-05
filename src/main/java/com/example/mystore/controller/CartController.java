package com.example.mystore.controller;

import com.example.mystore.model.Cart;
import com.example.mystore.model.Product;
import com.example.mystore.model.User;
import com.example.mystore.service.CartService;
import com.example.mystore.service.ProductService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {

    CartService cartService;
    ProductService productService;

    User user;
    Cart cart;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @RequestMapping(value = "/cart")
    public String openCart(Model model) {
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cart = cartService.getCartByUser(user);

        List<Product> productList = cart.getProducts();

        model.addAttribute("listProducts", productList);
        return "cart";
    }


    @PostMapping(value = "cart/add")
    public void addProduct(@RequestParam(value = "id") int id) {
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cart = cartService.getCartByUser(user);

        Product product = productService.getById(id);
        cart.addProduct(product);
        cartService.saveCart(cart);
    }

    @PostMapping(value = "cart/delete")
    public void deleteProduct(@RequestParam(value = "id") int id) {
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cart = cartService.getCartByUser(user);

        Product product = productService.getById(id);
        cart.deleteProduct(product);
        cartService.saveCart(cart);
    }
}
