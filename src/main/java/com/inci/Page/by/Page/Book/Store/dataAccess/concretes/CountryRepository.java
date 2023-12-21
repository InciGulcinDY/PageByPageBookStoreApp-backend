package com.inci.Page.by.Page.Book.Store.dataAccess.concretes;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Country;
import com.inci.Page.by.Page.Book.Store.services.dtos.country.response.GetAllCountryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    //JPQL Method
    boolean existsCountryByCountry(String country);
    boolean existsCountryById(int id);

    //Derived Query Method
    @Query("select new com.inci.Page.by.Page.Book.Store.services.dtos.country.response" +
            ".GetAllCountryResponse(c.country) " +
            "from Country c")
    List<GetAllCountryResponse> getAll();
}
