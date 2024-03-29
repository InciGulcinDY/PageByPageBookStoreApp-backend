package com.inci.Page.by.Page.Book.Store.services.dtos.language.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLanguageRequest {

    @NotBlank
    @Length(max = 20)
    private String language;

}
