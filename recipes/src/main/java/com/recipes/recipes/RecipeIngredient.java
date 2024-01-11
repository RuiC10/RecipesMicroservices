package com.recipes.recipes;

import com.recipes.recipes.Ingredient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="Ingredient-Service", url = "${application.config.ingredients-url}")
public interface RecipeIngredient {

    @GetMapping("/{ingredientId}")
    Ingredient getIngredient(@PathVariable("ingredientId") Long ingredientId);
}
