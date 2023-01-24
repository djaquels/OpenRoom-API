/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;

/**
 *
 * @author hjaca
 */

public class ApiError {
  private HttpStatus status;
  private LocalDateTime timestamp;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }
  private String message;
  private String debugMessage;
  private List<ApiSubError> subErrors;
  
  private ApiError(){
      timestamp = LocalDateTime.now();
  }
  
  ApiError(HttpStatus status){
      this();
      this.status = status;
  }
  
  ApiError(HttpStatus stauts, Throwable ex){
      this();
      this.status = status;
      this.message = "Unexpected error";
      this.debugMessage = ex.getLocalizedMessage();
  }
  
  ApiError(HttpStatus status, String message, Throwable ex){
      this();
      this.status = status;
      this.message = message;
      this.debugMessage = ex.getLocalizedMessage();
  }
}
