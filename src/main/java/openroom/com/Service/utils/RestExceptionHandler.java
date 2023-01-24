/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author hjaca
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler  {
    @Override
    protected ResponseEntity<Object>
    handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request){
            String error = "Malformed JSON request";
            return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error,ex));
    }
    
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleGenericException(Exception ex){
        String error = "API Server Error";
        ApiError apiError = new ApiError(HttpStatus.SERVICE_UNAVAILABLE);
        apiError.setMessage(error);
        apiError.setDebugMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
       return new ResponseEntity<>(apiError, apiError.getStatus());
   }
}
