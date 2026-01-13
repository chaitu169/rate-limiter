package org.example.ratelimiter.dtos;

import lombok.Data;

@Data
public class ModelRequestDto {
    private String model;
    private String question;
}
