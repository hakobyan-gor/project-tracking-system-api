package com.tracking.system.models;

import lombok.Builder;

@Builder
public record ResponseModel<T>(
        boolean success,
        T data,
        String message
) {
}