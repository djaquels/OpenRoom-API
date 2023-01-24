/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import openroom.com.Service.repositories.RoomsRepository;
import openroom.com.Service.utils.CreateRoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smattme.requestvalidator.RequestValidator;

/**
 *
 * @author hjaca
 */
@RestController
public class Rooms {
    @Autowired
    RoomsRepository roomsRepository;
    
    @PostMapping(value="/rooms/new", produces = "application/json")
    public Map<Object,String> createRoom(@RequestBody CreateRoomRequest createRoomRequest ) throws Exception{
        Map<String,String> rules = new HashMap<>();
        rules.put("roomName","required");
        rules.put("roomCategoryId","required");
        List<String> errors = RequestValidator.validate(createRoomRequest,rules);
        if(!errors.isEmpty()){
            throw new Exception(errors.toString());
        }
        HashMap<Object,String> response = new HashMap<>();
        response.put("message", "Room created successfully!");
        return response;
    }
       
}
