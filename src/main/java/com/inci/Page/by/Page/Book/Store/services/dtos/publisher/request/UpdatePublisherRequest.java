package com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request;

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
public class UpdatePublisherRequest {

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int id;

    @NotBlank
    @Length(max = 30)
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]*$",
            message = "Only include letters, special characters not allowed")
    private String publisher;

}
