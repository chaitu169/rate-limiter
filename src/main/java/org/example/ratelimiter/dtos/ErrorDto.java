package org.example.ratelimiter.dtos;

import lombok.Data;

@Data
public class ErrorDto {
    public ErrorDto(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public boolean isSuccess = false;
    public String errorMessage;
}
