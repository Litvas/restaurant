package com.restaurant.client.menuservice.handler;

import com.restaurant.client.menuservice.annotation.Loggable;
import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import com.restaurant.client.menuservice.payload.ExceptionResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Loggable
    @ExceptionHandler(MenuNotFoundException.class)
    public ResponseEntity<Object> handleMenuNotFoundException(Exception ex) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                String.valueOf(HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDto);
    }
}
