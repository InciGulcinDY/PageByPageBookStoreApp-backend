package com.inci.Page.by.Page.Book.Store.repositories;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Country;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetAllCountryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    // Derived Query Method
    boolean existsCountryByCountry(String country);


    //  JPQL Method
    @Query("select new com.inci.Page.by.Page.Book.Store.services.dtos.country.response" +
            ".GetAllCountryResponse(c.country) " +
            "from Country c")
    List<GetAllCountryResponse> getAll();
}
