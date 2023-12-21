package com.inci.Page.by.Page.Book.Store.services.dtos.author.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthorByNameResponse {
    private String name;
    private String surname;

    private String getFullName(String name, String surname){
        return name + " " + surname;
    }
}
