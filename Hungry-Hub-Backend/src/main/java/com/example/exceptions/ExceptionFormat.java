package com.example.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ExceptionFormat {
    private LocalDateTime timestamp;
    private String message;
    private String uri;
}
