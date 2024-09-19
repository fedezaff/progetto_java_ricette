package com.example.demo;

import com.example.demo.Ingredient;
import com.example.demo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientAliasService {

    @Autowired
    private RecipeIngredientsAliasesRepository RecipeIngredientAliasRepository;



    /* public String getCategories() {
        return ingredientRepository.getCategory();
    }  */
}