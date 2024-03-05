package com.inci.Page.by.Page.Book.Store.services.dtos.author.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAuthorsResponse {
    private String name;
    private String surname;
    private String quote;
    private String imagePath;
}
