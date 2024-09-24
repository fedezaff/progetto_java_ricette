package com.example.demo;

import com.example.demo.Ingredient;
import com.example.demo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

// Indica che questa classe è un servizio che gestisce la logica di business per le ricette
@Service
public class RecipeService {

    // Inietta il repository RecipeRepository per accedere ai dati delle ricette
    @Autowired
    private RecipeRepository recipeRepository;

    // Restituisce tutte le ricette disponibili nel repository
    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    // Restituisce tutte le origini (cucine) disponibili nel repository
    public List<String> getAllOrigin() {
        return recipeRepository.findOrigin();
    }

    // Cerca le ricette in base al nome fornito
    public List<Recipe> getRecipeByName(String nome) {
        // Crea un'istanza "esempio" di Recipe con il titolo da cercare
        Recipe recipeExample = new Recipe();
        recipeExample.setTitle(nome);

        // Usa l'ExampleMatcher per cercare in modo simile al titolo
        Example<Recipe> example = Example.of(recipeExample,
                ExampleMatcher.matching()
                        .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()) // Cerca il titolo in modo case-insensitive
        );

        // Restituisce tutte le ricette che corrispondono all'esempio fornito
        return recipeRepository.findAll(example);
    }
    
    // Restituisce una ricetta casuale
    public Recipe getRecipeRandom() {        
        return recipeRepository.findRandomRecipe();
    }

    // Restituisce tutte le ricette per una specifica origine (cucina)
    public List<Recipe> getRecipeByOrigin(String origine) {        
        return recipeRepository.findByOrigin(origine);
    }

    // Restituisce una ricetta specifica in base all'ID fornito
    public Recipe getRecipeByID(String id) {        
        return recipeRepository.findByID(id);
    }
}
