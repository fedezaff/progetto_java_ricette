package com.example.demo;

import com.example.demo.Ingredient;
import com.example.demo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;


    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    public List<String> getAllOrigin() {
        return recipeRepository.findOrigin();
    }

    public List<Recipe> getRecipeByName(String nome) {
        // Crea un'istanza "esempio" di Recipe con il nome da cercare
        Recipe recipeExample = new Recipe();
        recipeExample.setTitle(nome);

        // Usa l'ExampleMatcher per cercare con il LIKE
        Example<Recipe> example = Example.of(recipeExample,
                ExampleMatcher.matching()
                        .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()) // Cerca in modo simile al nome
        );

        return recipeRepository.findAll(example); // Restituisce tutte le ricette che corrispondono all'esempio
    }
    
    public Recipe getRecipeRandom() {        
        return recipeRepository.findRandomRecipe();
    }

    public List<Recipe> getRecipeByOrigin(String origine) {        
        return recipeRepository.findByOrigin(origine);
    }

    public Recipe getRecipeByID(String id) {        
        return recipeRepository.findByID(id);
    }
}