package org.example.ratelimiter.dtos;

import lombok.Data;

@Data
public class ModelResponseDto {
    public ModelResponseDto(String answer){
        this.answer = answer;
    }

    private final boolean isSuccess = true;
    private String answer;
}
