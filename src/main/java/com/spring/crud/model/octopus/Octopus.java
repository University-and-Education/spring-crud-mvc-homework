package com.spring.crud.model.octopus;

import com.spring.crud.model.Seafood;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "octopus")
public class Octopus extends Seafood {

    @Column(name = "peeled")
    private boolean peeled;

    public boolean isPeeled() {
        return peeled;
    }

    public void setPeeled(boolean peeled) {
        this.peeled = peeled;
    }
}