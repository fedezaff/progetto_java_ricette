package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")  
public class Ingredient {

    @Id
    @Column(name = "ingredient_id")  
    private Long ingredientID;

    @Column(name = "aliased_name")
    private String IngredientName;

    @Column(name = "ingredient_synonyms")
    private String ingredientSynonyms;

    @Column(name = "category_id")
    private Long categoryId;


    // Getters Setters
    public Ingredient() {}

        public Ingredient(Long ingredientID, String IngredientName, String ingredientSynonyms, Long categoryId) {
        this.ingredientID = ingredientID;
        this.IngredientName = IngredientName;
        this.ingredientSynonyms = ingredientSynonyms;
        this.categoryId = categoryId;
    } 

    public Long getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(Long ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getIngredientName() {
        return IngredientName;
    }

    public void setIngredientName(String IngredientName) {
        this.IngredientName = IngredientName;
    }

    public String getIngredientSynonyms() {
        return ingredientSynonyms;
    }

    public void setIngredientSynonyms(String ingredientSynonyms) {
        this.ingredientSynonyms = ingredientSynonyms;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
