/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;

/**
 *
 * @author hjaca
 */
public class ResponseFactory {
    private LocalDateTime timestamp;
    public Items createItem(){
        return null;
    }
    
    public Map<String,Object> getResponse(HttpStatus code,Integer page, Integer limit){
      Map<String,Object> response = new HashMap<>();
      Items list =  createItem();
      response.put("response_code", code);
      response.put("time",LocalDateTime.now().toString());
      response.put("resources", list.getItems());
      response.put("offset",page);
      response.put("limit",limit);
      return response;
    
    }
    
}
