package com.example.PhotoClone.web;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.PhotoClone.model.Photo;
import com.example.PhotoClone.service.PhotoService;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Initialization Successful";
    }

    @GetMapping("/photos")
    public Iterable<Photo> getAll() {
        return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.remove(id);
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
