package com.example.demo;

import com.example.demo.RecipeIngredient;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// Indica che questa interfaccia è un repository per l'entità RecipeIngredient
@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

    // Query nativa per ottenere gli ID delle ricette che contengono un ingrediente specifico
    @Query(value = "SELECT ri.Recipe_ID FROM recipe_ingredients_aliases ri INNER JOIN (SELECT Recipe_ID FROM recipe_ingredients_aliases GROUP BY Recipe_ID HAVING COUNT(Entity_ID) <= :maxIngredienti) filtered_recipes ON ri.Recipe_ID = filtered_recipes.Recipe_ID WHERE ri.Entity_ID = :ingredienteID", nativeQuery = true)
    // Metodo che restituisce una lista di ID delle ricette basate su un ingrediente e un massimo di ingredienti
    List<String> getRecipeId(@Param("ingredienteID") String ingredienteID, @Param("maxIngredienti") int maxIngredienti );
    
    // Query nativa per ottenere gli ID degli ingredienti di una ricetta specifica
    @Query(value = "SELECT Entity_ID FROM recipe_ingredients_aliases WHERE Recipe_ID = :ricettaPossibile", nativeQuery = true)
    // Metodo che restituisce una lista di ID degli ingredienti per una ricetta data
    List<String> getIngredientID(@Param("ricettaPossibile") String ricettaPossibile);

    // Query nativa per ottenere i nomi originali degli ingredienti di una ricetta specifica
    @Query(value = "SELECT Original_Ingredient_Name FROM recipe_ingredients_aliases WHERE Recipe_ID = :recipeID", nativeQuery = true)
    // Metodo che restituisce una lista dei nomi originali degli ingredienti per una ricetta data
    List<String> getIngredient(@Param("recipeID") String recipeID);
}
