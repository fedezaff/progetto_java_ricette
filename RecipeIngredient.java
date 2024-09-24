package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indica che questa classe rappresenta un'entità persistente nel database
@Entity
// Specifica che questa entità è mappata alla tabella "recipe_ingredient_aliases" nel database
@Table(name = "recipe_ingredient_aliases")
public class RecipeIngredient {

    // Indica che il campo recipeId è la chiave primaria della tabella
    @Id
    // Mappa il campo recipeId alla colonna "Recipe_ID" nel database
    @Column(name = "Recipe_ID")
    private Long recipeId;

    // Mappa il campo originalIngredientName alla colonna "Original_Ingredient_Name" nel database
    @Column(name = "Original_Ingredient_Name")
    private String originalIngredientName;

    // Mappa il campo aliasedIngredientName alla colonna "Aliased Ingredient Name" nel database
    @Column(name = "Aliased Ingredient Name")
    private String aliasedIngredientName;

    // Mappa il campo entityId alla colonna "Entity_ID" nel database
    @Column(name = "Entity_ID")
    private Long entityId;

    // Costruttore vuoto richiesto da JPA
    public RecipeIngredient() {}

    // Costruttore per inizializzare tutti i campi della classe
    public RecipeIngredient(Long recipeId, String originalIngredientName, String aliasedIngredientName, Long entityId) {
        this.recipeId = recipeId;
        this.originalIngredientName = originalIngredientName;
        this.aliasedIngredientName = aliasedIngredientName;
        this.entityId = entityId;
    }

    // Getter per recipeId
    public Long getRecipeId() {
        return recipeId;
    }

    // Setter per recipeId
    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    // Getter per originalIngredientName
    public String getOriginalIngredientName() {
        return originalIngredientName;
    }

    // Setter per originalIngredientName
    public void setOriginalIngredientName(String originalIngredientName) {
        this.originalIngredientName = originalIngredientName;
    }

    // Getter per aliasedIngredientName
    public String getAliasedIngredientName() {
        return aliasedIngredientName;
    }

    // Setter per aliasedIngredientName
    public void setAliasedIngredientName(String aliasedIngredientName) {
        this.aliasedIngredientName = aliasedIngredientName;
    }

    // Getter per entityId
    public Long getEntityId() {
        return entityId;
    }

    // Setter per entityId
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }
}
