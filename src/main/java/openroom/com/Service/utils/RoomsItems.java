/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

import java.util.ArrayList;
import java.util.List;
import openroom.com.Service.models.RoomsEntity;

/**
 *
 * @author hjaca
 */
public class RoomsItems implements Items {
    private List<RoomsEntity> rooms;
    @Override
    public List<ItemResponse> getItems() {
        List<ItemResponse> response = new ArrayList<>();
        for(RoomsEntity room: rooms){
             ItemResponse data = new ItemResponse();
             data.addKeyValuePair("room_name", room.getRoomName());
             response.add(data);
        }
        return response;
    }
    
    public RoomsItems(List<RoomsEntity> rooms){
        this.rooms = rooms;
    }
    
}
