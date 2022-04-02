package com.spring.crud.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SeafoodDTO {

    @NotBlank
    @Size(min = 6, max = 20)
    protected String productName;

    @Min(value = 100)
    protected Double weight;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}