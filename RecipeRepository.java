package com.example.demo;

import com.example.demo.Recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

// Indica che questa interfaccia è un repository per l'entità Recipe
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>, QueryByExampleExecutor<Recipe> {

    // Query nativa per trovare una ricetta casuale dalla tabella recipe_details
    @Query(value = "SELECT * FROM recipe_details ORDER BY RAND() LIMIT 1", nativeQuery = true)
    // Metodo che restituisce una ricetta casuale
    Recipe findRandomRecipe();

    // Query nativa per trovare ricette in base alla cucina specificata
    @Query(value = "SELECT * FROM recipe_details WHERE Cuisine = :origine", nativeQuery = true)
    // Metodo che restituisce una lista di ricette in base all'origine (cucina)
    List<Recipe> findByOrigin(@Param("origine") String origine);
    
    // Query nativa per trovare tutte le origini (cucine) uniche nella tabella recipe_details
    @Query(value = "SELECT Cuisine FROM recipe_details GROUP BY Cuisine", nativeQuery = true)
    // Metodo che restituisce una lista delle origini (cucine) disponibili
    List<String> findOrigin();

    // Query nativa per trovare una ricetta specifica in base al suo ID
    @Query(value = "SELECT * FROM recipe_details WHERE Recipe_ID = :id LIMIT 1", nativeQuery = true)
    // Metodo che restituisce una ricetta corrispondente all'ID specificato
    Recipe findByID(@Param("id") String id);
}
