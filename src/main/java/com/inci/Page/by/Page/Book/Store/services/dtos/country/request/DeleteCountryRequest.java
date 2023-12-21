package com.inci.Page.by.Page.Book.Store.services.dtos.country.request;

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
public class DeleteCountryRequest {

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int id;

}
