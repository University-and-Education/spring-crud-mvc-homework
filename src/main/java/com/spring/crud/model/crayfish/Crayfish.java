package com.spring.crud.model.crayfish;

import com.spring.crud.model.Seafood;

import javax.persistence.*;

@Entity
@Table(name = "crayfish", schema = "public")
public class Crayfish extends Seafood {

    @Column(name = "crayfish_type")
    @Enumerated(value = EnumType.STRING)
    private CrayfishType crayfishType;

    public CrayfishType getCrayfishType() {
        return crayfishType;
    }

    public void setCrayfishType(CrayfishType crayfishType) {
        this.crayfishType = crayfishType;
    }
}