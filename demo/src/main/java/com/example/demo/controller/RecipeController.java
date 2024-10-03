package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.model.RecipeOrigins;
import com.example.demo.service.IngredientService;
import com.example.demo.service.RecipeIngredientService;
import com.example.demo.service.RecipeOriginsService;
import com.example.demo.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @Autowired
    private RecipeOriginsService RecipeOriginsService;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @GetMapping("/recipe-origins-list")
    public List<RecipeOrigins> getAllOrigin() {
        return RecipeOriginsService.getAllOrigin();
    }

    @GetMapping("/recipes-name")
    public List<Recipe> getRecipeByName(@RequestParam String name) {
        return recipeService.getRecipeByName(name);
    }

    @GetMapping("/recipes-name/{id}")
    public Recipe getRecipeByID(@PathVariable String id) {
        return recipeService.getRecipeByID(id);
    }

    @GetMapping("/random")
    public Recipe getRecipeRandom() {
        return recipeService.getRecipeRandom();
    }

    @GetMapping("/recipe-origins")
    public List<Recipe> getRecipeByOrigin(@RequestParam String recipeOrigins) {
        String recipeOriginsId = RecipeOriginsService.getOriginId(recipeOrigins);
        return recipeService.getRecipeByOrigin(recipeOriginsId);
    }
    

    @GetMapping("/recipe-origins/{id}")
    public List<Recipe> getRecipeByOriginByID(@PathVariable String id) {
        return recipeService.getRecipeByOrigin(id);
    }

    @GetMapping("/make-it")
    public List<Recipe> getMakeIt(@RequestParam String ingredients) {
        // Suddividi gli ingredienti passati in una lista
        List<String> ingredientiList = List.of(ingredients.split(","));
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

    // @PostMapping("/add-recipe")
    // @ResponseStatus(code = HttpStatus.OK)
    // public String addRecipe(@RequestParam String name, @RequestParam String site, @RequestParam int recipeOrigins) {
    //     recipeService.addRecipe(name, site, recipeOrigins);
    //     return "Recipe added successfully";
    // }

    @PostMapping("/add-recipe")
    public String addRecipe(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "Recipe added successfully";
    }

    @DeleteMapping("/delete-recipe/{id}")
    public String deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
        return "Recipe deleted successfully";
    }

}