/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

/**
 *
 * @author hjaca
 */

abstract class ApiSubError{
    
}

public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;
    
    ApiValidationError(String object, String message){
        this.object = object;
        this.message = message;
    }
}
