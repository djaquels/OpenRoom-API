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
import openroom.com.Service.utils.CreateRoomCategoryRequest;
import openroom.com.Service.utils.ResponseFactory;
import openroom.com.Service.utils.RoomsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

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
    
    
    private  ResponseFactory response;
    
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
    @GetMapping(value="/rooms/categories", produces="application/json")
    public Map<Object,String> getRoomCategories() throws Exception{
      Map<Object,String> response = new HashMap<>();
      return response;
    }
    
    @GetMapping(value="/rooms/")
    public Map<String,Object> getRooms() throws Exception{
     this.response = new RoomsResponse(roomsRepository.findAll());
     return response.getResponse(HttpStatus.FOUND);
    }
    @PostMapping(value="/rooms/categories/new", produces="application/json")
    public Map<Object,String> createNewRoomCategory(@RequestBody CreateRoomCategoryRequest request) throws Exception{
        Map<Object,String> response = new HashMap<>();
        Map<String,String> rules = new HashMap<>();
        rules.put("categoryName","required");
        List<String> errors = RequestValidator.validate(request,rules);
        if(!errors.isEmpty()){
            throw new Exception(errors.toString());
        }
        RoomCategoryEntity newRoomCategory = new RoomCategoryEntity(); 
        newRoomCategory.setCategoryName(request.getCategoryName().toString().strip());
        roomCategoryRepository.save(newRoomCategory);
        response.put("message","new room category created successfully!");
        return response;
    }
       
}
