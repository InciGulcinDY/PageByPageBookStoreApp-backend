package com.inci.Page.by.Page.Book.Store.core.utilities.messages;

public interface MessageService {

    String getMessage(String keyword);
    String getMessageWithParams(String keyword, Object... params);

}
