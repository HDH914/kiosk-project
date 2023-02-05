package com.HDH.kiosk.handler;

import com.HDH.kiosk.dto.CMRespDto;
import com.HDH.kiosk.exception.CustomInternalServerErrorException;
import com.HDH.kiosk.exception.CustomValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

//    @ExceptionHandler(CustomInternalServerErrorException.class)
//    public ResponseEntity<?> validationErrorException(CustomValidationException e){
//        return ResponseEntity
//                .badRequest()
//                .body(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()));
//    }
}
