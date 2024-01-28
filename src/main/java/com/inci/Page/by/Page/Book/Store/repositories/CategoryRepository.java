package com.inci.Page.by.Page.Book.Store.repositories;

import com.inci.Page.by.Page.Book.Store.entities.concretes.Category;
import com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetAllCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    //  Derived Query Methods
    boolean existsCategoryByCategory(String category);

    //  JPQL Method
    @Query("select new com.inci.Page.by.Page.Book.Store.services.dtos.category.response.GetAllCategoryResponse" +
            "(c.category) " +
            "from Category c" )
    List<GetAllCategoryResponse> getAllCategories();

}
