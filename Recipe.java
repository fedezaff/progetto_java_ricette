package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indica che questa classe rappresenta un'entità persistente nel database
@Entity
// Specifica che questa entità è mappata alla tabella "recipe_details" nel database
@Table(name = "recipe_details")  
public class Recipe {

    // Indica che il campo recipeId è la chiave primaria della tabella
    @Id
    // Mappa il campo recipeId alla colonna "Recipe_ID" nel database
    @Column(name = "Recipe_ID")  
    private Long recipeId;

    // Mappa il campo title alla colonna "Title" nel database
    @Column(name = "Title")
    private String title;

    // Mappa il campo source alla colonna "Source" nel database
    @Column(name = "Source")
    private String source;

    // Mappa il campo cuisine alla colonna "Cuisine" nel database
    @Column(name = "Cuisine")
    private String cuisine;

    // Costruttore vuoto richiesto da JPA
    public Recipe() {}

    // Costruttore per inizializzare tutti i campi della classe
    public Recipe(Long recipeId, String title, String source, String cuisine) {
        this.recipeId = recipeId;
        this.title = title;
        this.source = source;
        this.cuisine = cuisine;
    } 

    // Getter per recipeId
    public Long getRecipeId() {
        return recipeId;
    }

    // Setter per recipeId
    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    // Getter per title
    public String getTitle() {
        return title;
    }

    // Setter per title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter per source
    public String getSource() {
        return source;
    }

    // Setter per source
    public void setSource(String source) {
        this.source = source;
    }

    // Getter per cuisine
    public String getCuisine() {
        return cuisine;
    }

    // Setter per cuisine
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}
