package com.seymur.vabisstask.exception;

import com.seymur.vabisstask.dto.response.ApiResponse;
import com.seymur.vabisstask.dto.response.ErrorResponse;
import com.seymur.vabisstask.dto.response.ValidationFailedResponseDTO;
import com.seymur.vabisstask.dto.response.ViolationDetailDTO;
import com.seymur.vabisstask.exception.custom.UserAlreadyExistsException;
import com.seymur.vabisstask.exception.custom.WrongPasswordException;
import com.seymur.vabisstask.exception.custom.WrongUserNameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return new ResponseEntity<>(new ApiResponse(false, new ErrorResponse(400, 400, Arrays.asList(ex.getMessage()))), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongUserNameException.class)
    public ResponseEntity<?> handleWrongUserNameException(WrongUserNameException ex) {
        return new ResponseEntity<>(new ApiResponse(false, new ErrorResponse(400, 400, Arrays.asList(ex.getMessage()))), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<?> handleWrongPasswordException(WrongPasswordException ex) {
        return new ResponseEntity<>(new ApiResponse(false, new ErrorResponse(400, 400, Arrays.asList(ex.getMessage()))), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        ValidationFailedResponseDTO validationFailedResponseDTO = new ValidationFailedResponseDTO();
        validationFailedResponseDTO.setTitle("Validasiya xətası.");
        List<ViolationDetailDTO> violationDetailDTOS = new ArrayList<>();
        fieldErrors.forEach(fieldError -> {
            ViolationDetailDTO violationDetailDTO = new ViolationDetailDTO();
            violationDetailDTO.setRejectedField(fieldError.getField());
            violationDetailDTO.setRejectedValue(fieldError.getRejectedValue());
            violationDetailDTOS.add(violationDetailDTO);
        });
        validationFailedResponseDTO.setViolations(violationDetailDTOS);
        return new ResponseEntity<>(validationFailedResponseDTO, HttpStatus.valueOf(422));
    }


}
