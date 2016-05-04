
package com.example.bookapi.books.json_model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */

public class SearchInfo implements Serializable {

    @SerializedName("textSnippet")
    @Expose
    private String textSnippet;

    /**
     * 
     * @return
     *     The textSnippet
     */
    public String getTextSnippet() {
        return textSnippet;
    }

    /**
     * 
     * @param textSnippet
     *     The textSnippet
     */
    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

}
