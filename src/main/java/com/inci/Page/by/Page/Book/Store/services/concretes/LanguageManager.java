package com.inci.Page.by.Page.Book.Store.services.concretes;

import com.inci.Page.by.Page.Book.Store.core.exceptions.types.NotFoundException;
import com.inci.Page.by.Page.Book.Store.core.utilities.mappers.ModelMapperService;
import com.inci.Page.by.Page.Book.Store.core.utilities.messages.MessageService;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.Result;
import com.inci.Page.by.Page.Book.Store.core.utilities.results.SuccessResult;
import com.inci.Page.by.Page.Book.Store.repositories.LanguageRepository;
import com.inci.Page.by.Page.Book.Store.entities.concretes.Language;
import com.inci.Page.by.Page.Book.Store.services.abstracts.LanguageService;
import com.inci.Page.by.Page.Book.Store.services.constants.Messages;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.AddLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.DeleteLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.request.UpdateLanguageRequest;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetAllLanguageResponse;
import com.inci.Page.by.Page.Book.Store.services.dtos.language.response.GetLanguageByIdResponse;
import com.inci.Page.by.Page.Book.Store.services.rules.LanguageBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

    private final ModelMapperService modelMapperService;
    private final LanguageRepository languageRepository;
    private final LanguageBusinessRule languageBusinessRule;
    private final MessageService messageService;

    @Override
    public Result add(AddLanguageRequest request) {
        //  Converting uppercase characters to lowercase
        request.setLanguage(request.getLanguage().toLowerCase());

        //  Business Rules:
        languageBusinessRule.existsLanguageByLanguage(request.getLanguage());

        //  Mapping
        Language language = modelMapperService.forRequest().map(request, Language.class);

        //  Saving
        languageRepository.save(language);

        return new SuccessResult(messageService.getMessage(Messages.Language.languageAddSuccess));
    }

    @Override
    public Result update(UpdateLanguageRequest request) {
        //  Converting uppercase characters to lowercase
        request.setLanguage(request.getLanguage().toLowerCase());

        //  Business Rules:
        languageBusinessRule.existsLanguageByLanguage(request.getLanguage());

        //  Mapping
        Language language = modelMapperService.forRequest().map(request, Language.class);

        //  Saving
        languageRepository.save(language);

        return new SuccessResult(messageService.getMessage(Messages.Language.languageUpdateSuccess));

    }

    @Override
    public Result delete(DeleteLanguageRequest request) {

        //  Checking the existence the language
        languageBusinessRule.existsLanguageById(request.getId());

        //  Deleting
        languageRepository.deleteById(request.getId());

        return new SuccessResult(Messages.Language.languageDeleteSuccess);
    }

    @Override
    public List<GetAllLanguageResponse> getAll() {
        return languageRepository.findAll().stream()
                .map(language -> modelMapperService.forResponse()
                        .map(language, GetAllLanguageResponse.class)).toList();
    }

    @Override
    public GetLanguageByIdResponse getById(int id) {
        //  Finding the relevant id!
        Language language = languageRepository.findById(id).orElseThrow(() ->
                new NotFoundException(messageService.getMessage(Messages.Language.getLanguageNotFoundMessage)));

        //  Mapping
        return modelMapperService.forResponse().map(language, GetLanguageByIdResponse.class);
    }
}
