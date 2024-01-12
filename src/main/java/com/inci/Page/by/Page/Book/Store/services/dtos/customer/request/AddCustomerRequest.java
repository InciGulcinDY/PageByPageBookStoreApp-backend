package com.inci.Page.by.Page.Book.Store.services.dtos.customer.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
    @NotBlank
    @Length(max = 30)
    private String name;

    @NotBlank
    @Length(max = 40)
    private String surname;

    @NotBlank
    @Length(max = 60)
    private String address;

    @NotBlank
    @Length(max = 40)
    private String email;

    @NotNull
    @Positive
    private int cityId;
}
