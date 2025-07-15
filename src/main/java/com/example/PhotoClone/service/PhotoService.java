package com.example.PhotoClone.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.PhotoClone.model.Photo;

@Service
public class PhotoService {

    private Map<String, Photo> db = new HashMap<>() {
        {
            put("1", new Photo("1", "photo1.jpg"));
            put("2", new Photo("2", "photo2.jpg"));
        }
    };

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setName(fileName);
        photo.setData(data);
        photo.setContentType(contentType);
        db.put(photo.getId(), photo);
        return photo;
    }
}
