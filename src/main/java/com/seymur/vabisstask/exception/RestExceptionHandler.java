package com.seymur.vabisstask.exception;

import com.seymur.vabisstask.dto.response.ApiResponse;
import com.seymur.vabisstask.dto.response.ErrorResponse;
import com.seymur.vabisstask.exception.custom.UserAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return new ResponseEntity<>(new ApiResponse(false, new ErrorResponse(400, 400, Arrays.asList(ex.getMessage()))), HttpStatus.BAD_REQUEST);
    }
}
