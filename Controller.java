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

    // Inietta il servizio IngredientService per gestire le operazioni sugli ingredienti
    @Autowired
    private IngredientService ingredientService;

    // Inietta il servizio RecipeService per gestire le operazioni sulle ricette
    @Autowired
    private RecipeService recipeService;
    
    // Inietta il servizio RecipeIngredientService per gestire le relazioni tra ricette e ingredienti
    @Autowired
    private RecipeIngredientService recipeIngredientService;

    // Endpoint per ottenere la lista di tutti gli ingredienti
    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    // Endpoint per ottenere la lista di tutte le ricette
    @GetMapping("/recipe")
    public List<Recipe> getAllRecipe() {
        return recipeService.getAllRecipe();
    }

    // Endpoint per ottenere la lista di tutte le origini disponibili
    @GetMapping("/origin")
    public List<String> getAllOrigin() {
        return recipeService.getAllOrigin();
    }

    // Endpoint per ottenere le ricette in base al nome
    @GetMapping("/recipe_by_name")
    public List<Recipe> getRecipeByName(@RequestParam String nome) {
        return recipeService.getRecipeByName(nome);
    }

    // Endpoint per ottenere una ricetta casuale
    @GetMapping("/random")
    public Recipe getRecipeRandom() {
        return recipeService.getRecipeRandom();
    }

    // Endpoint per ottenere le ricette in base all'origine
    @GetMapping("/recipe_by_origin")
    public List<Recipe> getRecipeByOrigin(@RequestParam String origine) {
        return recipeService.getRecipeByOrigin(origine);
    }

    // Endpoint per ottenere gli ingredienti di una ricetta basata sull'ID della ricetta
    @GetMapping("/recipe_ingredients")
    public List<String> getRecipeIngredients(@RequestParam String recipeID) {
        return recipeIngredientService.getIngredient(recipeID);
    }

    // Endpoint per ottenere le ricette che possono essere realizzate con una lista di ingredienti
    @GetMapping("/make_it")
    public List<Recipe> getMakeIt(@RequestParam String ingredienti) {
        // Suddivide la stringa degli ingredienti passati in una lista
        List<String> ingredientiList = List.of(ingredienti.split(","));
        List<String> IDingredientiList = new ArrayList<>();
        List<Recipe> ricette = new ArrayList<>();
    
        // Recupera gli ID di ciascun ingrediente e li aggiunge alla lista
        for (String ingrediente : ingredientiList) {
            IDingredientiList.add(ingredientService.getIngredientId(ingrediente));
        }
    
        // Ricette possibili basate sugli ingredienti
        List<String> ricettePossibili = new ArrayList<>();
        int maxIngredienti = IDingredientiList.size(); // Numero massimo di ingredienti forniti dall'utente
        for (String ingredienteID : IDingredientiList) {
            // Aggiunge alla lista delle ricette possibili le ricette che contengono l'ingrediente
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
    
        // Restituisce le ricette che possono essere fatte con gli ingredienti forniti
        return ricette;
    }
}
