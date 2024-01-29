package com.inci.Page.by.Page.Book.Store.services.dtos.book.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBookByIdResponse {
    private int id;

    private  String title;

    private String imagePath;

    private double unitPrice;

    private short numberOfPages;

    private String numberOfEditions;

    private int categoryId;

    private int languageId;

    private int authorId;

    private int publisherId;
}
