package com.example.demo.controller;

import com.example.demo.model.Ingredient;
import com.example.demo.model.IngredientList;
import com.example.demo.service.IngredientService;
import com.example.demo.service.RecipeIngredientService;
import com.example.demo.service.RecipeOriginsService;
import com.example.demo.service.RecipeService;

import jakarta.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private RecipeIngredientService recipeIngredientService;

    @Autowired
    private IngredientService ingredientService; // Serve per ottenere gli ID degli ingredienti

    @Autowired
    private RecipeOriginsService RecipeOriginsService;

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/ingredient_id")
    public String getIngredientId(@RequestParam String ingrediente) {
        return ingredientService.getIngredientId(ingrediente);
    }
    
    
    @GetMapping("/recipeIngredients/{recipeID}")
    public List<IngredientList> getRecipeIngredients(@PathVariable String recipeID) {
        List<String> testo = recipeIngredientService.getIngredient(recipeID);
        List<String> id = recipeIngredientService.getIngredientIDByRecipe(recipeID);
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

    
    

