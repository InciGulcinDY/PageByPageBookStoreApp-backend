package com.inci.Page.by.Page.Book.Store.services.dtos.publisher.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletePublisherRequest {

    @NotNull
    @Positive(message = "The value cannot be negative!")
    private int id;

}
