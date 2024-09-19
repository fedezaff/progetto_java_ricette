package com.example.demo;

import com.example.demo.Ingredient;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientsAliasesRepository extends JpaRepository<RecipeIngredientsAliases, Long> {


}
