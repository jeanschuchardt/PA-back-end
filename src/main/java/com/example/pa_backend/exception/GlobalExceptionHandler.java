package com.example.pa_backend.exception;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
@CommonsLog
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> handleServiceException(ServiceException se) {

        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("message", se.getMessage());
        responseData.put("service", "lotus");

        if (se.getStatus() == HttpStatus.NO_CONTENT || se.getStatus() == HttpStatus.NOT_FOUND) {
            log.warn(se.getMessage());
        } else {
            log.warn(se.getMessage(), se);
        }

        return new ResponseEntity<>(responseData, se.getStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> handleException(Exception e) {

        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("message", e.getMessage());
        responseData.put("service", "lotus");

        log.error(e.getMessage(), e);

        return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}