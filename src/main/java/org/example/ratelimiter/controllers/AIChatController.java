package org.example.ratelimiter.controllers;

import org.example.ratelimiter.dtos.ModelRequestDto;
import org.example.ratelimiter.dtos.ModelResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/ask")
public class AIChatController {

    @PostMapping
    public ResponseEntity<ModelResponseDto> askAI(@RequestBody ModelRequestDto requestDto){
        String answer = "Hi, how are you?";
        ModelResponseDto responseDto = new ModelResponseDto(answer);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
