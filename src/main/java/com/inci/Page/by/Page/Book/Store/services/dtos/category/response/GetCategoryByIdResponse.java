package com.inci.Page.by.Page.Book.Store.services.dtos.category.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryByIdResponse {
    private int id;
    private String category;
}
