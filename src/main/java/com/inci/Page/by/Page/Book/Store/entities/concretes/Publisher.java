package com.inci.Page.by.Page.Book.Store.entities.concretes;

import com.inci.Page.by.Page.Book.Store.entities.abstracts.BasicEntity;
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
public class Publisher extends BasicEntity {

    @Column(name = "publisher")
    private String publisher;

    @OneToMany(mappedBy = "publisher")
    private List<Magazine> magazines;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;


}
