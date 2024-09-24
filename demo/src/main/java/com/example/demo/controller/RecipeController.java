package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.service.IngredientService;
import com.example.demo.service.RecipeIngredientService;
import com.example.demo.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeIngredientService recipeIngredientService;

    @Autowired
    private IngredientService ingredientService; // Serve per ottenere gli ID degli ingredienti

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @GetMapping("/origin")
    public List<String> getAllOrigin() {
        return recipeService.getAllOrigin();
    }

    @GetMapping("/recipe_by_name")
    public List<Recipe> getRecipeByName(@RequestParam String nome) {
        return recipeService.getRecipeByName(nome);
    }

    @GetMapping("/random")
    public Recipe getRecipeRandom() {
        return recipeService.getRecipeRandom();
    }

    @GetMapping("/recipe_by_origin")
    public List<Recipe> getRecipeByOrigin(@RequestParam String origine) {
        return recipeService.getRecipeByOrigin(origine);
    }

    @GetMapping("/recipe_ingredients")
    public List<String> getRecipeIngredients(@RequestParam String recipeID) {
        return recipeIngredientService.getIngredient(recipeID);
    }

    @GetMapping("/make_it")
    public List<Recipe> getMakeIt(@RequestParam String ingredienti) {
        // Suddividi gli ingredienti passati in una lista
        List<String> ingredientiList = List.of(ingredienti.split(","));
        List<String> IDingredientiList = new ArrayList<>();
        List<Recipe> ricette = new ArrayList<>();
    
        // Recupera gli ID di ciascun ingrediente e li aggiunge alla lista
        for (String ingrediente : ingredientiList) {
            IDingredientiList.add(ingredientService.getIngredientId(ingrediente));
        }
    
        // Ricette possibili basate sugli ingredienti
        List<String> ricettePossibili = new ArrayList<>();
        int maxIngredienti = IDingredientiList.size();
        for (String ingredienteID : IDingredientiList) {
            ricettePossibili.addAll(recipeIngredientService.getRecipeId(ingredienteID, maxIngredienti));
        }
    
        // Per ogni ricetta possibile, verifica se gli ingredienti richiesti sono contenuti nella lista degli ingredienti
        for (String ricettaID : ricettePossibili) {
            // Recupera gli ingredienti della ricetta
            List<String> ingredientiRicetta = recipeIngredientService.getIngredientID(ricettaID);
    
            // Controlla se la lista di ingredienti fornita contiene tutti gli ingredienti della ricetta
            if (IDingredientiList.containsAll(ingredientiRicetta)) {
                // Aggiungi la ricetta alla lista delle ricette da restituire
                ricette.add(recipeService.getRecipeByID(ricettaID));
            }
        }
    
        return ricette;
    }
}