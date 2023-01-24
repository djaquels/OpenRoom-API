/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.controllers;

import com.smattme.requestvalidator.RequestValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import openroom.com.Service.models.RoomCategoryEntity;
import openroom.com.Service.repositories.RoomCategoryRepository;
import openroom.com.Service.utils.CreateRoomCategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hjaca
 */
@RestController
public class RoomCategory {
    @Autowired
    private RoomCategoryRepository roomCategoryRepository;
    
    @GetMapping(value="/roomCategory", produces="application/json")
    public Map<Object,String> getRoomCategories() throws Exception{
      Map<Object,String> response = new HashMap<>();
      return response;
    }
    @PostMapping(value="/roomCategory/new", produces="application/json")
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
