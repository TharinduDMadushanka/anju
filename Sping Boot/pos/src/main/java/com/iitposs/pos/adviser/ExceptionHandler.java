package com.iitposs.pos.adviser;

import com.iitposs.pos.exception.NotFoundException;
import com.iitposs.pos.util.enums.StandardResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    ResponseEntity<StandardResponse> notFoundExceptionHandler(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error Occurred",e.getMessage()), HttpStatus.NOT_FOUND
        );
    }

}
