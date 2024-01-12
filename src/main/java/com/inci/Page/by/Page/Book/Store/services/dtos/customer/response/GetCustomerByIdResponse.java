package com.inci.Page.by.Page.Book.Store.services.dtos.customer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerByIdResponse {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private int cityId;
}
