package com.user.managment.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String user, String userPhoneNumber, String string) {
    super(String.format("%s not found with the given input %s :'%s'",user,userPhoneNumber,string));
    }
}
