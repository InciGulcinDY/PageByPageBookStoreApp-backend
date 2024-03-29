package com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteMagazineRequest {
    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int id;
}
