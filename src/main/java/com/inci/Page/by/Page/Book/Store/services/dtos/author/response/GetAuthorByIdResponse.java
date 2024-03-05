package com.inci.Page.by.Page.Book.Store.services.dtos.author.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthorByIdResponse {
    private int id;
    private String name;
    private String surname;
    private String quote;
    private String imagePath;
}
