package com.example.demo.controller;

import com.example.demo.model.Ingredient;
import com.example.demo.service.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/ingredient_id")
    public String getIngredientId(@RequestParam String ingrediente) {
        return ingredientService.getIngredientId(ingrediente);
    }
}

    
    

