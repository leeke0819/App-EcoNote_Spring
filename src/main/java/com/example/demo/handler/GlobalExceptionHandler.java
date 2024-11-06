package com.example.demo.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler
    public ResponseEntity<String> handleNumberFormatException(NumberFormatException e){
        return ResponseEntity.status(401).body("your input didnt convert to Integer");
    }
    //Zero Division Exception에 대해 만들어보세요.
    @ExceptionHandler
    public ResponseEntity<String> handleArithmeticException(ArithmeticException e) {
        return ResponseEntity.status(400).body("Error : 0으로 나눌 수 없습니다.");
    }
}