package com.inci.Page.by.Page.Book.Store.services.abstracts;

import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.AddMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.DeleteMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.UpdateMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response.GetAllMagazineResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response.GetMagazineByIdResponse;

import java.util.List;

public interface MagazineService {
    void add (AddMagazineRequest request);
    void update (UpdateMagazineRequest request);
    void delete(DeleteMagazineRequest request);
    List<GetAllMagazineResponse> getAll();
    GetMagazineByIdResponse getById(int id);

}
