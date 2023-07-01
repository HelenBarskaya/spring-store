package com.example.mystore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected int id;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    protected Category category;

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "description", nullable = false)
    protected String description;

    @Column(name = "picture", nullable = false)
    protected String picture;

    @Column(name = "price", nullable = false)
    protected double price;

    public Product(String name, String description, String picture, double price) {
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.price = price;
    }
}
