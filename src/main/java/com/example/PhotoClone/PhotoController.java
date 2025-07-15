package com.example.PhotoClone;

import java.io.IOException;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

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
    public Collection<Photo> getAll() {
        return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = photoService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = photoService.remove(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = photoService.save(file.getOriginalFilename(), file.getBytes());
        return photo;
    }
}
