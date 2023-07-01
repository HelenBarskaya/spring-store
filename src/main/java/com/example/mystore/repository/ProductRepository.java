package com.example.mystore.repository;

import com.example.mystore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM PRODUCT WHERE ID_CATEGORY = ?1", nativeQuery = true)
    List<Product> getByIdCategory(int id);

    @Query(value = "SELECT * FROM PRODUCT WHERE NAME LIKE %?1%", nativeQuery = true)
    List<Product> getByPatternName(String pattern);
}
