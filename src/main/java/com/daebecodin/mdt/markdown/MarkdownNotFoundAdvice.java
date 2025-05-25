package com.daebecodin.mdt.markdown;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MarkdownNotFoundAdvice {
    @ExceptionHandler(MarkdownNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String MarkdownNotFondHandler(MarkdownNotFoundException ex) {
        return ex.getMessage();
    }
}
