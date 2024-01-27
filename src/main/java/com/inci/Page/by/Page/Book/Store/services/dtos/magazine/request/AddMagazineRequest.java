package com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMagazineRequest {

    @NotBlank
    @Length(max = 20)
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]*$",
            message = "Only include letters, special characters not allowed")
    private  String title;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private double unitPrice;

    @NotNull
    private LocalDate publishedDate;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int categoryId;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int languageId;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int publisherId;

}
