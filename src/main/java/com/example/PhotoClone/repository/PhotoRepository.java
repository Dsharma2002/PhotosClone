package com.example.PhotoClone.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.PhotoClone.model.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    
}
