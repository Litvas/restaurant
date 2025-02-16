package com.restaurant.client.clientservice.controllers;

import com.restaurant.client.clientservice.dtos.ExceptionResponseDTO;
import com.restaurant.client.clientservice.dtos.FieldErrorDTO;
import com.restaurant.client.clientservice.exceptions.ClientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClientNotFoundException(ClientNotFoundException ex) {
        ExceptionResponseDTO exceptionResponseDto = new ExceptionResponseDTO(
                String.valueOf(HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldErrorDTO> fieldErrorList = new ArrayList<>();
        ex.getFieldErrors().forEach((error) -> {
            FieldErrorDTO fieldError = new FieldErrorDTO();
            fieldError.setFieldName(error.getField());
            fieldError.setErrorMessage(error.getDefaultMessage());
            fieldErrorList.add(fieldError);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrorList);
    }
}
