package com.spring.crud.exception;

import com.spring.crud.dto.ErrorsDTO;
import com.spring.crud.dto.FieldErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NotFoundHandler(EntityNotFoundException ex) {
        return ex.getMessage();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<FieldErrorDTO> fieldErrors = new ArrayList<>();

        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();

        for (ObjectError o : objectErrors) {

            String fieldName = ((FieldError) o).getField();
            String errorMessage = o.getDefaultMessage();

            FieldErrorDTO f = new FieldErrorDTO();
            f.setField(fieldName);
            f.setMessage(errorMessage);

            fieldErrors.add(f);

        }

        ErrorsDTO errorsDTO = new ErrorsDTO();
        errorsDTO.setFieldErrors(fieldErrors);

        return new ResponseEntity<>(errorsDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
