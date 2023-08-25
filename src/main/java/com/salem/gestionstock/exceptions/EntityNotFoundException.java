package com.salem.gestionstock.exceptions;

import lombok.Getter;

import java.awt.event.FocusEvent;

public class EntityNotFoundException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;

    public EntityNotFoundException(String message){
        super(message);
    }
    public EntityNotFoundException(String message , Throwable cause,ErrorCodes errorCodes){
    super(message,cause);
    this.errorCodes = errorCodes;
    }
    public EntityNotFoundException(String message,ErrorCodes errorCodes){
        super(message);
        this.errorCodes = errorCodes;
    }
}
