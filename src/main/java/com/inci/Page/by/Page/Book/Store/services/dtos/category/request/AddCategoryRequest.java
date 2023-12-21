package com.inci.Page.by.Page.Book.Store.services.dtos.category.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddCategoryRequest {
    @NotBlank
    @Length(max = 40, message = "Category cannot have more than 40 characters!")
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]*$",
            message = "Only include letters, special characters not allowed")
    private String category;
}
