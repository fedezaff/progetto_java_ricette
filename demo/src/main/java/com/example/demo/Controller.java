package com.example.demo;

import com.example.demo.Ingredient;
import com.example.demo.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private RecipeService recipeService;

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
    public List<String> getMakeIt(@RequestParam String ingredienti) {
        // recupera il parametro e divido gli ingredienti in un arraylist
        List<String> ingredientiList = List.of(ingredienti.split(","));
        List<String> IDingredientiList = new ArrayList<>();
        
        for (String ingrediente : ingredientiList) {
            IDingredientiList.add(ingredientService.getIngredientId(ingrediente));
        }

        return ingredientiList;
    }
}
