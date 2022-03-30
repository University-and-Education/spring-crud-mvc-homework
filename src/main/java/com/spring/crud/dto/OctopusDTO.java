package com.spring.crud.dto;

public class OctopusDTO extends SeafoodDTO {

    private boolean peeled;

    public boolean isPeeled() {
        return peeled;
    }

    public void setPeeled(boolean peeled) {
        this.peeled = peeled;
    }
}
