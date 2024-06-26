package com.spring.restfulsimpleapi.dto;

import lombok.Builder;

@Builder
public record ProductResponse(Long id,
        String title,
        String description,
        Double price,
        String imageUrl) {
}
