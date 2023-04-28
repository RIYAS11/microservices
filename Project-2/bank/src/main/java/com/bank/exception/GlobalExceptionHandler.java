package com.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> allException(Exception ex , WebRequest wr){

        ErrorDetails er = new ErrorDetails(wr.getDescription(false) , LocalDateTime.now() , ex.getMessage());

        return new ResponseEntity<ErrorDetails>( er , HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetails> accountException(AccountException ae , WebRequest wr){

        ErrorDetails er = new ErrorDetails(wr.getDescription(false) , LocalDateTime.now() , ae.getMessage());

        return new ResponseEntity<ErrorDetails>(er , HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> accountException(UserException ae , WebRequest wr){

        ErrorDetails er = new ErrorDetails(wr.getDescription(false) , LocalDateTime.now() , ae.getMessage());

        return new ResponseEntity<ErrorDetails>(er , HttpStatus.BAD_REQUEST );
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> dataValidationExceptionHandler(MethodArgumentNotValidException ne){

        ErrorDetails err = new ErrorDetails();
        err.setTims(LocalDateTime.now());
        err.setMessage("Validaton error");
        err.setDetails(ne.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }


    //	Exception Handler for No URI found or wrong uri
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noUriHandlerFoundException(NoHandlerFoundException nfe,WebRequest req){


        ErrorDetails err = new ErrorDetails(req.getDescription(false), LocalDateTime.now(), nfe.getMessage() );

        return new ResponseEntity<ErrorDetails>(err,HttpStatus.OK);
    }


}
