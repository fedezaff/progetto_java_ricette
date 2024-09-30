package com.example.demo.service;

import com.example.demo.model.Ingredient;
import com.example.demo.model.IngredientList;
import com.example.demo.repository.RecipeIngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeIngredientService {

    
    @Autowired
    private IngredientService ingredientService;

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

    public List<String> getIngredientIDByRecipe(String recipeID) {
        return RecipeIngredientRepository.getIngredientIDByRecipe(recipeID);
    }

    public List<IngredientList> getRecipeIngrdientById(String recipeID) {
        List<String> testo = getIngredient(recipeID);
        List<String> id = getIngredientIDByRecipe(recipeID);
        List<Ingredient> ingredienti = new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            ingredienti.add(ingredientService.getIngredientById(id.get(i)));
        }
        List<IngredientList> ingredientiList = new ArrayList<>();
        for (int i = 0; i < testo.size(); i++) {
            ingredientiList.add(new IngredientList(testo.get(i), ingredienti.get(i)));
        }
        return ingredientiList;
    }
}