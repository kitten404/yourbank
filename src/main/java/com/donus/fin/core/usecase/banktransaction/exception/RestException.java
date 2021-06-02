package com.donus.fin.core.usecase.banktransaction.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestException {

    @ExceptionHandler(NotFoundException.class)
    public Object processNotFoundError(NotFoundException ex) {
       return new ResponseEntity<Object>(MessageResponse.createResponse(ex.getMensagem()),
    		   HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object processInvalidField(
    		  MethodArgumentNotValidException ex) {
    	
    		    List<String> errors = new ArrayList<String>();
    		    
    		    ex.getBindingResult().getFieldErrors().forEach(e ->{
    		    	 errors.add(e.getField() + ": " +e.getDefaultMessage());
    		    });
    		    
    		    return new ResponseEntity<Object>(errors,
    		    		   HttpStatus.BAD_REQUEST);
    		}
    
    @ExceptionHandler(GeneralError.class)
    public Object processGenericError(GeneralError ex) {
       return new ResponseEntity<Object>(MessageResponse.createResponse(ex.getMensagem()),
    		   HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
