
package com.example.bookapi.books.json_model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */


public class Pdf implements Serializable {

    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;

    /**
     * 
     * @return
     *     The isAvailable
     */
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * 
     * @param isAvailable
     *     The isAvailable
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
