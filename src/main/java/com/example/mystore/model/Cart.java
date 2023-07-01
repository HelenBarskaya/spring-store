package com.example.mystore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Table(name = "cart")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected int id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user", nullable = false)
    protected User user;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "cart_products",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    protected List<Product> products = new LinkedList<>();

    public Cart(User user) {
        this.user = user;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }
}
