package com.example.demo;

import com.example.demo.Ingredient;
import com.example.demo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Indica che questa classe è un servizio e gestisce la logica di business per gli ingredienti
@Service
public class IngredientService {

    // Inietta il repository IngredientRepository per accedere ai dati degli ingredienti
    @Autowired
    private IngredientRepository ingredientRepository;

    // Restituisce una lista di tutti gli ingredienti presenti nel database
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    // Restituisce l'ID di un ingrediente dato il suo nome alias (Aliased_Ingredient_Name)
    public String getIngredientId(String ingrediente) {
        return ingredientRepository.getIngredientId(ingrediente);
    }

    /* Metodo commentato che potrebbe restituire le categorie degli ingredienti
    public String getCategories() {
        return ingredientRepository.getCategory();
    }
    */
}
