package com.tracking.system.controllers;

import com.tracking.system.models.ResponseModel;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BaseController {

    public ResponseModel<?> createErrorResult(Exception e) {
        return new ResponseModel<>(
                false,
                null,
                e.getMessage()
        );
    }

    public ResponseModel<?> createErrorResult(String message) {
        return new ResponseModel<>(
                false,
                null,
                message
        );
    }

    public <R> ResponseModel<?> createSuccessResult(R data, String message) {
        return new ResponseModel<>(
                true,
                data,
                message
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseModel<?> handleException(MethodArgumentNotValidException exception) {
        return new ResponseModel<>(
                false,
                null,
                getFieldError(exception.getBindingResult().getFieldErrors())
        );
    }

    private String getFieldError(List<FieldError> fieldErrors) {
        if (!fieldErrors.isEmpty()) {
            FieldError fieldError = fieldErrors.get(0);
            return String.format("Field '%s' %s", fieldError.getField(), fieldError.getDefaultMessage());
        }
        return "Validation error";
    }

}