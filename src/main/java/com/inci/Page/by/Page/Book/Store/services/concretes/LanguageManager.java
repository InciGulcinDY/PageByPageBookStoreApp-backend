package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.dataAccess.LanguageRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Language;
import com.inci.Page.by.Page.Book.Store.services.abstracts.LanguageService;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.AddLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.DeleteLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.UpdateLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetAllLanguageResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetLanguageByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

    private final ModelMapperService modelMapperService;
    private final LanguageRepository languageRepository;

    @Override
    public void add(AddLanguageRequest request) {

        //  Converting uppercase characters to lowercase
        request.setLanguage(request.getLanguage().toLowerCase());

        //  Business Rules:
        //  Check the language in DB
        if (languageRepository.existsLanguageByLanguage(request.getLanguage())){
            throw new RuntimeException("The language entered is already exist!");
        }

        //  Mapping
        Language language = modelMapperService.forRequest().map(request, Language.class);

        //  Saving
        languageRepository.save(language);

    }

    @Override
    public void update(UpdateLanguageRequest request) {

        //  Converting uppercase characters to lowercase
        request.setLanguage(request.getLanguage().toLowerCase());

        //  Business Rules:
        //  Check the language in DB
        if (languageRepository.existsLanguageByLanguage(request.getLanguage())){
            throw new RuntimeException("The language entered is already exist!");
        }

        //  Mapping
        Language language = modelMapperService.forRequest().map(request, Language.class);

        //  Saving
        languageRepository.save(language);

    }

    @Override
    public void delete(DeleteLanguageRequest request) {

        //  Checking the existance the language
        languageRepository.findById(request.getId()).orElseThrow();

        //Delete
        languageRepository.deleteById(request.getId());

    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        return null;
    }

    @Override
    public GetLanguageByIdResponse getById(int id) {
        return null;
    }
}
