package com.example.PhotoClone.service;

import org.springframework.stereotype.Service;

import com.example.PhotoClone.model.Photo;
import com.example.PhotoClone.repository.PhotoRepository;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setName(fileName);
        photo.setData(data);
        photo.setContentType(contentType);
        photoRepository.save(photo);
        return photo;
    }
}
