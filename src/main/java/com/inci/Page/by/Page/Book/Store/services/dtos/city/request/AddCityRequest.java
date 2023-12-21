package com.inci.Page.by.Page.Book.Store.services.dtos.city.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
public class AddCityRequest {
    @NotBlank
    @Length(max = 40, message = "City cannot have more than 40 characters!")
    @Pattern(regexp = "^[a-zA-ZçÇğĞıİöÖşŞüÜ]*$",
            message = "Only include letters, special characters not allowed")
    private String city;

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int countryId;
}
