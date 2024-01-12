package com.inci.Page.by.Page.Book.Store.entities.concretes;

import com.inci.Page.by.Page.Book.Store.entities.abstracts.BasicEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "magazines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Magazine extends BasicEntity {

    @Column(name = "title")
    private  String title;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
