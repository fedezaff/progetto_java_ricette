package com.example.demo.repository;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query(value = "SELECT Entity_ID FROM ingredients WHERE Aliased_Ingredient_Name = :ingrediente", nativeQuery = true)
    String getIngredientId(@Param("ingrediente") String ingrediente);

}