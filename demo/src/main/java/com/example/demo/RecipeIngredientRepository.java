package com.example.demo;

import com.example.demo.RecipeIngredient;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    @Query(value = "SELECT Recipe_ID FROM recipe_ingredients_aliases WHERE Entity_ID = :ingredienteID", nativeQuery = true)
    List<String> getRecipeId(@Param("ingredienteID") String ingredienteID);
    
    @Query(value = "SELECT Entity_ID FROM recipe_ingredients_aliases WHERE Recipe_ID = :ricettaPossibile", nativeQuery = true)
    List<String> getIngredientID(@Param("ricettaPossibile") String ricettaPossibile);

    @Query(value = "SELECT Original_Ingredient_Name FROM recipe_ingredients_aliases WHERE Recipe_ID = :recipeID", nativeQuery = true)
    List<String> getIngredient(@Param("recipeID") String recipeID);

}
