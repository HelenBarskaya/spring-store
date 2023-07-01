package com.example.mystore.repository;

import com.example.mystore.model.Cart;
import com.example.mystore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByUser(User user);
}
