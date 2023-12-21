package com.inci.Page.by.Page.Book.Store.entities.abstracts;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Category;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private  String name;

    @Column(name = "image")
    private String image;

    @Column(name = "unit_price")
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
