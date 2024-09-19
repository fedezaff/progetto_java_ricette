package com.example.demo;

import com.example.demo.Ingredient;
import com.example.demo.IngredientRepository;
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
