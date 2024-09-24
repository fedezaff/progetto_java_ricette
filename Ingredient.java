package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indica che questa classe rappresenta una tabella del database
@Entity
// Definisce il nome della tabella corrispondente nel database
@Table(name = "ingredients")  
public class Ingredient {

    // Indica che questo campo è la chiave primaria della tabella
    @Id
    // Mappa questo campo alla colonna "Entity_ID" della tabella
    @Column(name = "Entity_ID")  
    private Long entityId;

    // Mappa il campo alla colonna "Aliased_Ingredient_Name" della tabella
    @Column(name = "Aliased_Ingredient_Name")
    private String aliasedIngredientName;

    // Mappa il campo alla colonna "Ingredient Synonyms" della tabella
    @Column(name = "Ingredient Synonyms")
    private String ingredientSynonyms;

    // Mappa il campo alla colonna "Category" della tabella
    @Column(name = "Category")
    private String category;

    // Costruttore vuoto richiesto da JPA
    public Ingredient() {}

    // Costruttore per inizializzare tutti i campi
    public Ingredient(Long entityId, String aliasedIngredientName, String ingredientSynonyms, String category) {
        this.entityId = entityId;
        this.aliasedIngredientName = aliasedIngredientName;
        this.ingredientSynonyms = ingredientSynonyms;
        this.category = category;
    }

    // Getter e setter per entityId
    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    // Getter e setter per aliasedIngredientName
    public String getAliasedIngredientName() {
        return aliasedIngredientName;
    }

    public void setAliasedIngredientName(String aliasedIngredientName) {
        this.aliasedIngredientName = aliasedIngredientName;
    }

    // Getter e setter per ingredientSynonyms
    public String getIngredientSynonyms() {
        return ingredientSynonyms;
    }

    public void setIngredientSynonyms(String ingredientSynonyms) {
        this.ingredientSynonyms = ingredientSynonyms;
    }

    // Getter e setter per category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
