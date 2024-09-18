package com.example.demo;

import com.example.demo.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>, QueryByExampleExecutor<Recipe>{
}
