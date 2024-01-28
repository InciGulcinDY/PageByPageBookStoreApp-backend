package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.NotFoundException;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.SuccessResult;
import com.inci.Page.by.Page.Book.Store.repositories.MagazineRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Magazine;
import com.inci.Page.by.Page.Book.Store.services.abstracts.MagazineService;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.AddMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.DeleteMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.request.UpdateMagazineRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response.GetAllMagazineResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.magazine.response.GetMagazineByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.rules.MagazineBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MagazineManager implements MagazineService {
    private final MagazineRepository magazineRepository;
    private final ModelMapperService modelMapperService;
    private final MagazineBusinessRule magazineBusinessRule;
    private final MessageService messageService;

    @Override
    public Result add(AddMagazineRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setTitle(request.getTitle().toLowerCase());

        //  Business Rules
        magazineBusinessRule.existsMagazineByTitle(request.getTitle());

        //  Mapping
        Magazine magazine = modelMapperService.forRequest().map(request, Magazine.class);

        //Saving
        magazineRepository.save(magazine);

        return new SuccessResult(messageService.getMessage(Messages.Magazine.magazineAddSuccess));
    }

    @Override
    public Result update(UpdateMagazineRequest request) {
        //  Converting uppercase letters to lowercase letters
        request.setTitle(request.getTitle().toLowerCase());

        //  Business Rules
        magazineBusinessRule.existsMagazineByTitle(request.getTitle());

        //  Mapping
        Magazine magazine = modelMapperService.forRequest().map(request, Magazine.class);

        //Saving
        magazineRepository.save(magazine);

        return new SuccessResult(messageService.getMessage(Messages.Magazine.magazineUpdateSuccess));
    }

    @Override
    public Result delete(DeleteMagazineRequest request) {

        //  Checking the existence of the magazine
        magazineBusinessRule.existsMagazineById(request.getId());

        //Delete the magazine
        magazineRepository.deleteById(request.getId());

        return new SuccessResult(messageService.getMessage(Messages.Magazine.magazineDeleteSuccess));
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
        Magazine magazine = magazineRepository.findById(id).orElseThrow(() ->
                new NotFoundException(Messages.Magazine.getMagazineNotFoundMessage));

        //  Mapping
        return modelMapperService.forResponse().map(magazine, GetMagazineByIdResponse.class);
    }
}
