package com.example.demo.service;

import com.example.demo.model.Ingredient;
import com.example.demo.repository.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public String getIngredientId(String ingrediente) {
        return ingredientRepository.getIngredientId(ingrediente);
    }

    /* public String getCategories() {
        return ingredientRepository.getCategory();
    }  */
}
