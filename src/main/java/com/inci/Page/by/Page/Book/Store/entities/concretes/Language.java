package com.inci.Page.by.Page.Book.Store.entities.concretes;

import com.inci.Page.by.Page.Book.Store.entities.abstracts.BasicEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language extends BasicEntity {

    @Column(name = "language")
    private String language;

    @OneToMany(mappedBy = "language")
    private List<Magazine> magazines;

    @OneToMany(mappedBy = "language")
    private List<Book> books;
}
