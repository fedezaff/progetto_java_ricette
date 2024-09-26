package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RecipeIngredient;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    @Query(value = "SELECT ri.Recipe_ID FROM recipe_ingredients_aliases ri INNER JOIN (SELECT Recipe_ID FROM recipe_ingredients_aliases GROUP BY Recipe_ID HAVING COUNT(Entity_ID) <= :maxIngredienti) filtered_recipes ON ri.Recipe_ID = filtered_recipes.Recipe_ID WHERE ri.Entity_ID = :ingredienteID", nativeQuery = true)
    List<String> getRecipeId(@Param("ingredienteID") String ingredienteID, @Param("maxIngredienti") int maxIngredienti );
    
    @Query(value = "SELECT Entity_ID FROM recipe_ingredients_aliases WHERE Recipe_ID = :ricettaPossibile", nativeQuery = true)
    List<String> getIngredientID(@Param("ricettaPossibile") String ricettaPossibile);

    @Query(value = "SELECT Original_Ingredient_Name FROM recipe_ingredients_aliases WHERE Recipe_ID = :recipeID", nativeQuery = true)
    List<String> getIngredient(@Param("recipeID") String recipeID);

    @Query(value = "SELECT Entity_ID FROM recipe_ingredients_aliases WHERE Recipe_ID = :recipeID", nativeQuery = true)
    List<String> getIngredientIDByRecipe(@Param("recipeID") String recipeID);

}
