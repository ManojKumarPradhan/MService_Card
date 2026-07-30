package com.bigob.card.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.bigob.card.dto.ResponseError;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseError {

    private String apiPath;
    private HttpStatus statusCode;
    private String  errorMessage;
    private LocalDateTime errorTime;

}