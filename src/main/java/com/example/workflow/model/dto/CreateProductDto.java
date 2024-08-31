package com.example.workflow.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductDto(

        @NotBlank @NotNull String name,
        String description
){
}
