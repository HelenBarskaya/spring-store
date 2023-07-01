package com.example.mystore.service;

import com.example.mystore.model.Cart;
import com.example.mystore.model.User;
import com.example.mystore.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    protected CartRepository cartRepository;
    public static final String ID_NOT_EXIST_EXCEPTION = "Cart with '%s' id is not found";

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(int id) throws Exception {
        return cartRepository.findById(id).orElseThrow(() -> exceptionProvider(id));
    }

    public Cart getCartByUser(User user) {
        Cart cart = cartRepository.findByUser(user);
        if (cart != null) return cart;
        else return new Cart(user);
    }

    public void deleteCartById(int id) throws Exception {
        cartRepository.delete(cartRepository.findById(id)
                .orElseThrow(() -> exceptionProvider(id)));
    }

    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    protected Exception exceptionProvider(int id) {
        String message = String.format(ID_NOT_EXIST_EXCEPTION, id);

        return new IllegalArgumentException(message);
    }
}
