package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_details")  
public class Recipe {

    @Id
    @Column(name = "recipe_id")  
    private Long recipeId;

    @Column(name = "title")
    private String title;

    @Column(name = "source")
    private String site;

    @Column(name = "recipe_origins_id")
    private Long recipeOriginsId;

    // Getters Setters
    public Recipe() {}

        public Recipe(Long recipeId, String title, String site, Long recipeOriginsId) {
        this.recipeId = recipeId;
        this.title = title;
        this.site = site;
        this.recipeOriginsId = recipeOriginsId;
    } 

    public Long getRecipeId() {
        return recipeId;
    }

    // public void setRecipeId(Long RecipeId) {
    //     this.recipeId = recipeId;
    // }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Long getRecipeOriginsId() {
        return recipeOriginsId;
    }

    public void getRecipeOriginsId(Long recipeOriginsId) {
        this.recipeOriginsId = recipeOriginsId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
