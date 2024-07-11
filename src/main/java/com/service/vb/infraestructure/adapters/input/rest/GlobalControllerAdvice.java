package com.service.vb.infraestructure.adapters.input.rest;

import com.service.vb.domain.exception.ClientNotFoundException;
import com.service.vb.domain.model.ErrorExceptionResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.service.vb.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClientNotFoundException.class)
    public ErrorExceptionResponse handleClientNotFoundException(){
        return ErrorExceptionResponse
                .builder()
                .code(CLIENT_NOT_FOUND.getCode())
                .message(CLIENT_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorExceptionResponse handleMethodArgumentsNotValidException(MethodArgumentNotValidException e){
        return ErrorExceptionResponse
                .builder()
                .code(INVALID_CLIENT_FOUND.getCode())
                .message(INVALID_CLIENT_FOUND.getMessage())
                .errors(e.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList())
                )
                .timestamp(LocalDateTime.now())
                .build();

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorExceptionResponse handleGenericErrorException(Exception e){
        return ErrorExceptionResponse
                .builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .errors(Collections.singletonList(e.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
