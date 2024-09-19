package com.example.demo;

import com.example.demo.RecipeIngredient;
import com.example.demo.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {

    @Autowired
    private RecipeIngredientRepository RecipeIngredientRepository;



    public List<String> getRecipeId(String ingredienteID) {
        return RecipeIngredientRepository.getRecipeId(ingredienteID);
    }    
}