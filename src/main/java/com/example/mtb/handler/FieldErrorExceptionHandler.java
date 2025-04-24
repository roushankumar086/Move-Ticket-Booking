package com.example.mtb.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        // Step 3: Get all object errors
        Map<String, String> errorMap = new HashMap<>();
        var objectErrors = ex.getBindingResult().getAllErrors();

        // Step 4: Iterate and downcast to FieldError
        objectErrors.forEach(error -> {
            if (error instanceof FieldError fieldError) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            } else {
                // fallback for ObjectError without field binding
                errorMap.put("error", error.getDefaultMessage());
            }
        });

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }


}
