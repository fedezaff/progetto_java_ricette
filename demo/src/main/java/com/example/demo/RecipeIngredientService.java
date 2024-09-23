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