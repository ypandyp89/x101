package com.ktx.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MyBadRequestException extends RuntimeException {

    public MyBadRequestException(final String message,final Throwable cause){
        super(message+"@@",cause);
    }

    public MyBadRequestException(final String message){
        super(message+"@@");
    }

    public MyBadRequestException(final Throwable cause) {
        super(cause);
    }
}
