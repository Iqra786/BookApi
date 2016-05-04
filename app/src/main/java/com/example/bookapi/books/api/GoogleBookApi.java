package com.example.bookapi.books.api;

import com.example.bookapi.books.json_model.Book;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */

public interface GoogleBookApi {

//    @GET("/books/v1/volumes?q=quaran&maxResults=10")
    @GET("/books/v1/volumes?maxResults=10")
    Call<Book> loadBooks(@Query("q") String book_Name);

}
