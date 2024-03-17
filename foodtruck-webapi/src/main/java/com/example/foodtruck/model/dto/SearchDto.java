package com.example.foodtruck.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchDto {
    private String foodItem;
}
