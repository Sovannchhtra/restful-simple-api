package com.spring.restfulsimpleapi.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record ProductRequest(
        String title,
        String description,
        Double price,
        String imageUrl) {
}
