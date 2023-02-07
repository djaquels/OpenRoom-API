/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hjaca
 */
public class ItemResponse {
    private Map<String, Object> body;
    
    public ItemResponse(){
      this.body = new HashMap<>();
    }
    
    public void addKeyValuePair(String key, String value){
     this.body.put(key, value);
    }
    
    public Map<String,Object> getResource(){
      return this.body;
    }
    
}
