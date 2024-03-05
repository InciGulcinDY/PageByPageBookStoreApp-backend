package com.inci.Page.by.Page.Book.Store.services.dtos.book.response;

import com.inci.Page.by.Page.Book.Store.services.dtos.author.response.GetAuthorByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetCategoryByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetLanguageByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.publisher.response.GetPublisherByIdResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBookResponse {
    private int id;

    private  String title;

    private String imagePath;

    private double unitPrice;

    private short numberOfPages;

    private String numberOfEditions;

    private String summary;

    private GetCategoryByIdResponse category;

    private GetLanguageByIdResponse language;

    private GetAuthorByIdResponse author;

    private GetPublisherByIdResponse publisher;
}
