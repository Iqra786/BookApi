package com.example.bookapi.books;

import com.example.bookapi.books.json_model.Book;
import com.example.bookapi.books.json_model.Item;
import com.example.bookapi.books.api.GoogleBookApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */
public class RetrofitBookApi implements Callback<Book> {

    private com.example.bookapi.books.Callback mCallback;

    public RetrofitBookApi(com.example.bookapi.books.Callback callback) {
        mCallback = callback;

    }


    @Override
    public void onResponse(Call<Book> call, Response<Book> response) {
        if (response != null) {
            Book retrievedData = response.body();
            List<Item> items = retrievedData.getItems();
            if (mCallback != null) {
                mCallback.onSuccess(items);
            }
        }
    }

    @Override
    public void onFailure(Call<Book> call, Throwable t) {
        if (mCallback != null) {
            mCallback.onFailure(t.getMessage());
        }
    }

    public void fetchBooks(String bookName) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.googleapis.com").addConverterFactory(GsonConverterFactory.create()).build();
        GoogleBookApi apiBook = retrofit.create(GoogleBookApi.class);
        Call<Book> result = apiBook.loadBooks(bookName);
        result.enqueue(this);
    }


}
