package com.example.PhotoClone;

import jakarta.validation.constraints.NotEmpty;

public class Photo {

    private String id;
    @NotEmpty
    private String fileName;

    public Photo() {
    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return fileName;
    }

    public void setName(String fileName) {
        this.fileName = fileName;
    }
}
