package com.example.demo;

import com.example.demo.Ingredient;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// Definisce il repository per l'entità Ingredient, fornendo metodi di accesso ai dati
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    // Query nativa che seleziona l'Entity_ID di un ingrediente dato il suo nome (Aliased_Ingredient_Name)
    @Query(value = "SELECT Entity_ID FROM ingredients WHERE Aliased_Ingredient_Name = :ingrediente", nativeQuery = true)
    // Metodo che restituisce l'ID di un ingrediente specifico
    String getIngredientId(@Param("ingrediente") String ingrediente);

}
