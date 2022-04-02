package com.spring.crud.dto;

import com.spring.crud.model.crayfish.CrayfishType;

import javax.validation.constraints.NotNull;

public class CrayfishDTO extends SeafoodDTO {

    @NotNull
    private CrayfishType crayfishType;

    public CrayfishType getCrayfishType() {
        return crayfishType;
    }

    public void setCrayfishType(CrayfishType crayfishType) {
        this.crayfishType = crayfishType;
    }
}
