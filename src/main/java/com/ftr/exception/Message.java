package com.ftr.exception;


import lombok.Data;

@Data
public class Message {
    String errorMessage;
    String errorCode;
    String errorType;
}
