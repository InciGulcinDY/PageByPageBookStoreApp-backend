package com.inci.Page.by.Page.Book.Store.core.utilities.results;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//@RequiredArgsConstructor?????
public class Result {
    private boolean success;    // a boolean field indicating whether an operation was successful or not
    private String message;     // a string field containing a message related to the result of the operation

    //  Constructors:
    public Result(boolean success) {
      this.success = success;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
