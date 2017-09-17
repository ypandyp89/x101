package com.ktx.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MyConflictException extends RuntimeException {

    public MyConflictException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyConflictException(final String message) {
        super(message);
    }

    public MyConflictException(final Throwable cause) {
        super(cause);
    }

}
