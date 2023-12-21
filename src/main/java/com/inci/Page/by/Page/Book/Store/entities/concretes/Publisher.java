package com.inci.Page.by.Page.Book.Store.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "publisher")
    private String publisher;


    @OneToMany(mappedBy = "publisher")
    List<Magazine> magazines;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;


}
