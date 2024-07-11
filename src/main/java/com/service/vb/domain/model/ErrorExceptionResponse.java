package com.service.vb.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class ErrorExceptionResponse {
    private String code;
    private String message;
    private List<String> errors;
    private LocalDateTime timestamp;
}
