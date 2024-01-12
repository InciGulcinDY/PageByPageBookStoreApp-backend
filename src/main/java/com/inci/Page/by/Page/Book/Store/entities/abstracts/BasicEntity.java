package com.inci.Page.by.Page.Book.Store.entities.abstracts;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class BasicEntity {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_date", nullable = true)
    private LocalDate updatedDate;

    @Column(name = "deleted_date", nullable = true)
    private LocalDate deletedDate;

    @PrePersist
    private void beforeAdd() {
        createdDate = LocalDate.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        updatedDate = LocalDate.now();
    }

    @PreRemove
    private void beforeDelete(){deletedDate = LocalDate.now();}

}
