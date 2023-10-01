package com.ftr.exception;

import lombok.Data;


public class FtrCustomException extends Exception{
    String errorMess;
    String errorCode;
    String errorTyp;

public FtrCustomException(String mess,String code, String type){
    errorMess = mess;
    errorCode = code;
    errorTyp = type;
}

}
