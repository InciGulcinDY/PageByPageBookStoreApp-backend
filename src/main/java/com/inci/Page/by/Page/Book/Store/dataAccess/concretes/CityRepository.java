package com.inci.Page.by.Page.Book.Store.dataAccess.concretes;

import com.inci.Page.by.Page.Book.Store.entities.concretes.City;
import com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetAllCitiesResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    boolean existsCityByCity(String city);

    //Derived Query Method
    @Query("select new com.inci.Page.by.Page.Book.Store.services.dtos.city.response.GetAllCitiesResponse" +
            "(c.city, " +
            "new com.inci.Page.by.Page.Book.Store.services.dtos.country.response." +
            "GetCountryByIdResponse(co.country)) " +
            "from City c " +
            "inner join c.country co")
    List<GetAllCitiesResponse> getAll();
}
