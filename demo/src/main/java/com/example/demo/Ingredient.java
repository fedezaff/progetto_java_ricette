package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredients")  
public class Ingredient {

    @Id
    @Column(name = "Entity_ID")  
    private Long entityId;

    @Column(name = "Aliased_Ingredient_Name")
    private String aliasedIngredientName;

    @Column(name = "Ingredient Synonyms")
    private String ingredientSynonyms;

    @Column(name = "Category")
    private String category;

    // Getters Setters
    public Ingredient() {}

        public Ingredient(Long entityId, String aliasedIngredientName, String ingredientSynonyms, String category) {
        this.entityId = entityId;
        this.aliasedIngredientName = aliasedIngredientName;
        this.ingredientSynonyms = ingredientSynonyms;
        this.category = category;
    } 

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getAliasedIngredientName() {
        return aliasedIngredientName;
    }

    public void setAliasedIngredientName(String aliasedIngredientName) {
        this.aliasedIngredientName = aliasedIngredientName;
    }

    public String getIngredientSynonyms() {
        return ingredientSynonyms;
    }

    public void setIngredientSynonyms(String ingredientSynonyms) {
        this.ingredientSynonyms = ingredientSynonyms;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
