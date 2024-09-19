package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_details")  
public class Recipe {

    @Id
    @Column(name = "Recipe_ID")  
    private Long recipeId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Source")
    private String source;

    @Column(name = "Cuisine")
    private String cuisine;

    // Getters Setters
    public Recipe() {}

        public Recipe(Long recipeId, String title, String source, String cuisine) {
        this.recipeId = recipeId;
        this.title = title;
        this.source = source;
        this.cuisine = cuisine;
    } 

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long RecipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String Cuisine) {
        this.cuisine = cuisine;
    }
}
