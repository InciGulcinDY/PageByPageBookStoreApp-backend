package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.dataAccess.MagazineRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Magazine;
import com.inci.Page.by.Page.Book.Store.services.abstracts.MagazineService;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.AddMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.DeleteMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.UpdateMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response.GetAllMagazineResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response.GetMagazineByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MagazineManager implements MagazineService {
    private final MagazineRepository magazineRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public void add(AddMagazineRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setTitle(request.getTitle().toLowerCase());

        //  Business Rules
        if(magazineRepository.existsMagazineByTitle(request.getTitle())){
            throw new RuntimeException();
        }

        //Mapping
        Magazine magazine = modelMapperService.forRequest().map(request, Magazine.class);

        //Saving
        magazineRepository.save(magazine);
    }

    @Override
    public void update(UpdateMagazineRequest request) {

        //  Converting uppercase letters to lowercase letters
        request.setTitle(request.getTitle().toLowerCase());

        //Business Rules
        if(magazineRepository.existsMagazineByTitle(request.getTitle())){
            throw new RuntimeException();
        }

        //Mapping
        Magazine magazine = modelMapperService.forRequest().map(request, Magazine.class);

        //Updating
        magazineRepository.save(magazine);

    }

    @Override
    public void delete(DeleteMagazineRequest request) {

        //  Checking the existence of the author
        magazineRepository.findById(request.getId()).orElseThrow();

        //Delete the magazine
        magazineRepository.deleteById(request.getId());

    }

    @Override
    public List<GetAllMagazineResponse> getAll() {
        return magazineRepository.findAll().stream()
                .map(magazine -> modelMapperService.forResponse()
                        .map(magazine,GetAllMagazineResponse.class)).toList();
    }

    @Override
    public GetMagazineByIdResponse getById(int id) {
        //  Finding the relevant id!
        Magazine magazine = magazineRepository.findById(id).orElseThrow();

        //  Mapping
        return modelMapperService.forResponse().map(magazine, GetMagazineByIdResponse.class);

    }
}
