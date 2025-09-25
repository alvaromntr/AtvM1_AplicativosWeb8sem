package com.example.crud.domain.category;

import jakarta.validation.constraints.NotBlank;

public record RequestCategory (
    @NotBlank
    String category
){
}
