package com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPublisherRequest {

    @NotBlank
    @Length(max = 30)
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]*$",
            message = "Only include letters, special characters not allowed")
    private String publisher;

}
