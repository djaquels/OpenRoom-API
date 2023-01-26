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
import java.util.ArrayList;
import java.util.Optional;
import openroom.com.Service.models.RoomCategoryEntity;
import openroom.com.Service.models.RoomsEntity;
import openroom.com.Service.repositories.RoomCategoryRepository;

/**
 *
 * @author hjaca
 */
@RestController
public class Rooms {
    @Autowired
    private RoomsRepository roomsRepository;
    
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;
    
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
        Optional<RoomCategoryEntity>  category=  roomCategoryRepository.findById(createRoomRequest.getRoomCategoryId());
        RoomsEntity newRoom = new RoomsEntity();
        newRoom.setRoomName(createRoomRequest.getRoomName());
        List<RoomCategoryEntity> categoriesList = new ArrayList<>();
        categoriesList.add(category.get());
        newRoom.setRoomCategoryList(categoriesList);
        roomsRepository.save(newRoom);
        response.put("message", "Room created successfully!");
        return response;
    }
       
}
