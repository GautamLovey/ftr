package com.ftr.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FtrCustomException.class)
    public ResponseEntity<Message> userNotFound(FtrCustomException ex){
        Message mess = new Message();
        mess.setErrorMessage(ex.errorMess);
        mess.setErrorCode(ex.errorCode);
        mess.setErrorType(ex.errorTyp);
        return ResponseEntity.ok(mess);
    }

}
