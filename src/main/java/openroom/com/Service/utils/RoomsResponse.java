/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

import java.util.List;
import openroom.com.Service.models.RoomsEntity;

/**
 *
 * @author hjaca
 */
public class RoomsResponse extends ResponseFactory{
    
    public List<RoomsEntity> rooms;
    
    @Override
    public Items createItem(){
      return new RoomsItems(this.rooms);
    }
    
    public RoomsResponse(List<RoomsEntity> results){
     this.rooms = results;
    }
}
