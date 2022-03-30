package com.spring.crud.model.caviar;

import com.spring.crud.model.Seafood;

import javax.persistence.*;

@Entity
@Table(name = "caviar", schema = "public")
public class Caviar extends Seafood {

    @Column(name = "caviar_color")
    @Enumerated(value = EnumType.STRING)
    private CaviarColor caviarColor;

    @Column(name = "fish")
    @Enumerated(value = EnumType.STRING)
    private Fish fish;

    @Column(name = "artificial")
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