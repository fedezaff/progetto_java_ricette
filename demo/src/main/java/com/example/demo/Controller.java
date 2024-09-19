package com.example.demo;

import com.example.demo.Ingredient;
import com.example.demo.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;


@RestController
public class Controller {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;
    
    @Autowired
    private RecipeIngredientService recipeIngredientService; // Iniezione del RecipeIngredientService

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/recipe")
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
        for (String ingredienteID : IDingredientiList) {
            ricettePossibili.addAll(recipeIngredientService.getRecipeId(ingredienteID));
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
    
        return ricette; // Restituisce le ricette che possono essere fatte con gli ingredienti forniti
    }
    
}
