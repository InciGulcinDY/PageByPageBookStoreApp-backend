package com.inci.Page.by.Page.Book.Store.entities.concretes;

import com.inci.Page.by.Page.Book.Store.entities.abstracts.BasicEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BasicEntity {

    @Column(name = "title")
    private  String title;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "number_of_pages")
    private short numberOfPages;

    @Column(name = "number_of_editions")
    private String numberOfEditions;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
