package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_origins")
public class RecipeOrigins {

    @Id
    @Column(name = "recipe_origins_id")
    private Long recipe_origins_id;

    @Column(name = "recipe_origins")
    private String recipe_origins;

    // Getters e Setters

    public RecipeOrigins() {}

    public RecipeOrigins(Long recipe_origins_id, String recipe_origins) {
        this.recipe_origins_id = recipe_origins_id;
        this.recipe_origins = recipe_origins;
    }

    
    public Long getRecipe_origins_id() {
        return recipe_origins_id;
    }

    public void setRecipe_origins_id(Long recipe_origins_id) {
        this.recipe_origins_id = recipe_origins_id;
    }

    public String getRecipe_origins() {
        return recipe_origins;
    }

    public void setRecipe_origins(String recipe_origins) {
        this.recipe_origins = recipe_origins;
    }

}