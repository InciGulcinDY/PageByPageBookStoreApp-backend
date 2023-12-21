package com.inci.Page.by.Page.Book.Store.services.dtos.city.response;


import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetCountryByIdResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCitiesResponse {

    private String city;

    private GetCountryByIdResponse country;
}
