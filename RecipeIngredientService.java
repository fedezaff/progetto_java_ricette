package com.example.demo;

import com.example.demo.RecipeIngredient;
import com.example.demo.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Indica che questa classe è un servizio e gestisce la logica di business per gli ingredienti delle ricette
@Service
public class RecipeIngredientService {

    // Inietta il repository RecipeIngredientRepository per accedere ai dati degli ingredienti delle ricette
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    // Restituisce una lista di ID delle ricette che contengono un ingrediente specifico
    public List<String> getRecipeId(String ingredienteID, int maxIngredienti) {
        return recipeIngredientRepository.getRecipeId(ingredienteID, maxIngredienti);
    }    

    // Restituisce una lista di ID degli ingredienti associati a una ricetta specificata
    public List<String> getIngredientID(String ricettaPossibile) {
        return recipeIngredientRepository.getIngredientID(ricettaPossibile);
    }    

    // Restituisce una lista dei nomi originali degli ingredienti per una ricetta specificata
    public List<String> getIngredient(String recipeID) {
        return recipeIngredientRepository.getIngredient(recipeID);
    }    
}
