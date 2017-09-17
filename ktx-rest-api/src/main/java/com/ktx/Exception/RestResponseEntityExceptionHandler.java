package com.ktx.Exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@NoArgsConstructor
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private org.slf4j.Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        return handleExceptionInternal(ex,message(HttpStatus.BAD_REQUEST,ex),headers,HttpStatus.BAD_REQUEST,request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,final HttpHeaders headers,final HttpStatus status,final WebRequest request) {
        return handleExceptionInternal(ex,message(HttpStatus.BAD_REQUEST,ex),headers,HttpStatus.BAD_REQUEST,request);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public final ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex,final WebRequest request){
        return handleExceptionInternal(ex,message(HttpStatus.BAD_REQUEST,ex),new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }


    private ApiError message(final HttpStatus httpStatus,final Exception ex){
        final String message=ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
        final String devMessage= ExceptionUtils.getRootCauseMessage(ex);

        return new ApiError(httpStatus.value(),message,devMessage);
    }
}
