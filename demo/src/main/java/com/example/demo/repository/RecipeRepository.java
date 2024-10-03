package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recipe;

import org.springframework.data.repository.query.Param;


@Repository

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "SELECT * FROM recipe_details ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Recipe findRandomRecipe();

    @Query(value = "SELECT * FROM recipe_details WHERE recipe_origins_id = :origine", nativeQuery = true)
    List<Recipe> findByOrigin(@Param("origine") String origine);

    @Query(value = "SELECT * FROM recipe_details WHERE Recipe_ID = :id LIMIT 1", nativeQuery = true)
    Recipe findByID(@Param("id") String id);

    @Query(value = "DELETE FROM recipe_details WHERE recipe_id = :id", nativeQuery = true)
    void deleteRecipe(@Param("id") int id);

}