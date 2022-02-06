package com.spring.crud.dto;

import com.spring.crud.model.caviar.CaviarColor;
import com.spring.crud.model.caviar.Fish;

public class CaviarDTO extends SeafoodDTO {

    private CaviarColor caviarColor;

    private Fish fish;

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