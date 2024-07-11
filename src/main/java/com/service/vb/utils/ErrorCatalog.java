package com.service.vb.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    CLIENT_NOT_FOUND("ERR_CLIENT_001", "Client not found."),
    INVALID_CLIENT_FOUND("ERR_CLIENT_002","Invalid Client parameters."),
    GENERIC_ERROR("ERR_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message){
        this.code = code;
        this.message = message;
    }
}
