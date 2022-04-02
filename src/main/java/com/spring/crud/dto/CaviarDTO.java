package com.spring.crud.dto;

import com.spring.crud.model.caviar.CaviarColor;
import com.spring.crud.model.caviar.Fish;

import javax.validation.constraints.NotNull;

public class CaviarDTO extends SeafoodDTO {

    @NotNull
    private CaviarColor caviarColor;

    @NotNull
    private Fish fish;

    @NotNull
    private Boolean artificial;

    public CaviarColor getCaviarColor() {
        return caviarColor;
    }

    public void setCaviarColor(CaviarColor caviarColor) {
        this.caviarColor = caviarColor;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public Boolean isArtificial() {
        return artificial;
    }

    public void setArtificial(Boolean artificial) {
        this.artificial = artificial;
    }
}