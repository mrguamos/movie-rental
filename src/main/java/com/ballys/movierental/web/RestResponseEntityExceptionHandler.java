package com.ballys.movierental.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { MovieRentalException.class })
    public ResponseEntity<Object> handleMovieRentalException(MovieRentalException ex, WebRequest request) {
        log.error("MovieRentalException", ex);
        return handleExceptionInternal(ex, ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

}
