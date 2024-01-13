package com.recipes.recipes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PrepStep-Service", url = "${application2.config.prepStep-url}")
public interface RecipePreparationStep {

    @GetMapping("/{PrepStepId}")
    PreparationStep getPrepartionStep(@PathVariable("PrepStepId") Long PrepStepId);
}
