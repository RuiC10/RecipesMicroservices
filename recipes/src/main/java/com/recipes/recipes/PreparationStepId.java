package com.recipes.recipes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class PreparationStepId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long prepStepId;

    public PreparationStepId(Long id, Long prepStepId) {
        this.id = id;
        this.prepStepId = prepStepId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrepStepId() {
        return prepStepId;
    }

    public void setPrepStepId(Long prepStepId) {
        this.prepStepId = prepStepId;
    }

    @Override
    public String toString() {
        return "PreparationStep{" +
                "id=" + id +
                ", prepStepId=" + prepStepId +
                '}';
    }
}
