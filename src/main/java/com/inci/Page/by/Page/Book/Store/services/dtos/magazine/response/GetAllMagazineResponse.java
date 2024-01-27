package com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMagazineResponse {

    private int id;

    private  String title;

    private double unitPrice;

    private LocalDate publishedDate;

    private int categoryId;

    private int languageId;

    private int publisherId;

}
