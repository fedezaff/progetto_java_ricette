package com.example.demo.service;

import com.example.demo.model.RecipeIngredient;
import com.example.demo.repository.RecipeIngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {

    @Autowired
    private RecipeIngredientRepository RecipeIngredientRepository;

    public List<String> getRecipeId(String ingredienteID, int maxIngredienti) {
        return RecipeIngredientRepository.getRecipeId(ingredienteID, maxIngredienti);
    }    

    public List<String> getIngredientID(String ricettaPossibile) {
        return RecipeIngredientRepository.getIngredientID(ricettaPossibile);
    }    

    public List<String> getIngredient(String recipeID) {
        return RecipeIngredientRepository.getIngredient(recipeID);
    }    
}