package com.figpop.demoopenfeign.exceptions.handlers;

import com.figpop.demoopenfeign.exceptions.model.ApiError;
import com.figpop.demoopenfeign.exceptions.model.BadRequestException;
import com.figpop.demoopenfeign.exceptions.model.ErrorCodeEnum;
import com.figpop.demoopenfeign.exceptions.model.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> notFound(Exception ex) {
        logger.error("error : " + ex.getMessage());
        ApiError message = new ApiError(ErrorCodeEnum.NOT_FOUND.toString(),new Date() , "error 404" , ex.getMessage());
        return new ResponseEntity<ApiError>(message,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class})
    public ResponseEntity<ApiError> badRequest(Exception ex) {
        logger.error("error : " + ex.getMessage());
        ApiError message = new ApiError(ErrorCodeEnum.BAD_REQUEST.toString(),new Date() , "error parameter" , ex.getMessage());
        return new ResponseEntity<ApiError>(message,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> internalError(Exception ex) {
        logger.error("error : " + ex.getMessage());
        ApiError message = new ApiError(ErrorCodeEnum.INTERNAL_SERVER_ERROR.toString(),new Date() , "internal server error" , ex.getMessage());
        return new ResponseEntity<ApiError>(message,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex, WebRequest request) {
        logger.error("error : " + ex.getMessage());
        ApiError message = new ApiError(ErrorCodeEnum.BAD_REQUEST.toString(),new Date() , "error parameter" , ex.getMessage());
        return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
    }



}
