package com.inci.Page.by.Page.Book.Store.services.dtos.book.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRequest {

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int id;

    @NotBlank
    @Length(max = 30)
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]*$",
            message = "Only include letters, special characters not allowed")
    private  String title;

    @NotBlank
    @Length(max = 40)
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]*$",
            message = "Only include letters, special characters not allowed")
    private String imagePath;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private double unitPrice;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private short numberOfPages;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private String numberOfEditions;

    @NotBlank
    @Length(max = 100)
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]*$",
            message = "Only include letters, special characters not allowed")
    private String summary;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int categoryId;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int languageId;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int authorId;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int publisherId;
}
