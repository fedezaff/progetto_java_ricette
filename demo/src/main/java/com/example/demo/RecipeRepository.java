package com.example.demo;

import com.example.demo.Recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>, QueryByExampleExecutor<Recipe>{

    @Query(value = "SELECT * FROM recipe_details ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Recipe findRandomRecipe();

    @Query(value = "SELECT * FROM recipe_details WHERE Cuisine = :origine", nativeQuery = true)
    List<Recipe> findByOrigin(@Param("origine") String origine);
    
    @Query(value = "SELECT Cuisine FROM recipe_details GROUP BY Cuisine", nativeQuery = true)
    List<String> findOrigin();

    @Query(value = "SELECT * FROM recipe_details WHERE Recipe_ID = :id LIMIT 1", nativeQuery = true)
    Recipe findByID(@Param("id") String id);
}
