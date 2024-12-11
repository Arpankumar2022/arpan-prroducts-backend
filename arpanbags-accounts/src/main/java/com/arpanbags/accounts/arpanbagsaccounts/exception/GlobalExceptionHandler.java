package com.arpanbags.accounts.arpanbagsaccounts.exception;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGlobalException(Exception ex, WebRequest request) {
        ProblemDetail body = ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(500),ex.getLocalizedMessage());
        body.setType(URI.create("localhost:9093/api/v1/**"));
        body.setTitle(ex.getMessage());
        return body;
    }

    @ExceptionHandler(AccountNameAlreadyExists.class)
    public ProblemDetail handleAccountNameAlready(AccountNameAlreadyExists ex, WebRequest request) {
        ProblemDetail body = ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(500),ex.getLocalizedMessage());
        body.setType(URI.create("localhost:9093/api/v1/create-account"));
        body.setTitle("Please send correct values !!");
        return body;
    }

    @ExceptionHandler(AccountNameDoesNotExist.class)
    public ProblemDetail handleAccountNameAlready(AccountNameDoesNotExist ex, WebRequest request) {
        ProblemDetail body = ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(500),ex.getLocalizedMessage());
        body.setType(URI.create("localhost:9093/api/v1/create-account"));
        body.setTitle("No Record found !!");
        return body;
    }
}
