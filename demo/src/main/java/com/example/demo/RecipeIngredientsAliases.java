package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_ingredient_aliases")
public class RecipeIngredientsAliases {

    @Id
    @Column(name = "Recipe ID")
    private Long recipeId;

    @Column(name = "Original Ingredient Name")
    private String originalIngredientName;

    @Column(name = "Aliased Ingredient Name")
    private String aliasedIngredientName;

    @Column(name = "Entity ID")
    private Long entityId;

    // Getters e Setters

    public void RecipeIngredientAlias() {}

    public void RecipeIngredientAlias(Long recipeId, String originalIngredientName, String aliasedIngredientName, Long entityId) {
        this.recipeId = recipeId;
        this.originalIngredientName = originalIngredientName;
        this.aliasedIngredientName = aliasedIngredientName;
        this.entityId = entityId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getOriginalIngredientName() {
        return originalIngredientName;
    }

    public void setOriginalIngredientName(String originalIngredientName) {
        this.originalIngredientName = originalIngredientName;
    }

    public String getAliasedIngredientName() {
        return aliasedIngredientName;
    }

    public void setAliasedIngredientName(String aliasedIngredientName) {
        this.aliasedIngredientName = aliasedIngredientName;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
}