package com.recipes.recipes.repository;

import com.recipes.recipes.PreparationStep;
import com.recipes.recipes.Recipe;
import com.recipes.recipes.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RecipesRepositoryTest {
    @Autowired
    private RecipeRepository rp;

    @Test
    public void RecipeRepo_Save_Return(){
        Recipe r = new Recipe(1L, List.of(new PreparationStep(1L, 1L, "Cook")), "Codfish");
        Recipe saveRecipe = this.rp.save(r);

    }

}
