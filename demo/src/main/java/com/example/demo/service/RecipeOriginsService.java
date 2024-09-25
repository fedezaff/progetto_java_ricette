package com.example.demo.service;

import com.example.demo.model.RecipeOrigins;
import com.example.demo.repository.RecipeOriginsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeOriginsService {
    
    @Autowired
    private RecipeOriginsRepository RecipeOriginsRepository;

    public List<RecipeOrigins> getAllOrigin() {
        return RecipeOriginsRepository.findOrigin();
    }

    public String getOriginId(String name) {
        return RecipeOriginsRepository.findById(name);
    }
}
