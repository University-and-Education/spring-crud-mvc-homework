package com.spring.crud.dto;

import com.spring.crud.model.crayfish.CrayfishType;

public class CrayfishDTO extends SeafoodDTO {

    private CrayfishType crayfishType;

    public CrayfishType getCrayfishType() {
        return crayfishType;
    }

    public void setCrayfishType(CrayfishType crayfishType) {
        this.crayfishType = crayfishType;
    }
}
