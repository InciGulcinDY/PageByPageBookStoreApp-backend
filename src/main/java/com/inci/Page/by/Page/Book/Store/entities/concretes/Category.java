package com.inci.Page.by.Page.Book.Store.entities.concretes;

import com.inci.Page.by.Page.Book.Store.entities.abstracts.BasicEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BasicEntity {

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "category")
    private List<Magazine> magazines;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

}
