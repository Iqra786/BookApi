package com.example.bookapi.books;

import com.example.bookapi.books.json_model.Item;

import java.util.List;

/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */
public interface Callback {

    void onSuccess(List<Item> articles);

    void onFailure(String error);
}
