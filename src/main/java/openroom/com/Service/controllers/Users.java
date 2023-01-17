/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.controllers;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author hjaca
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import openroom.com.Service.repositories.UsersRepository;

@RestController
public class Users {
    @Autowired
    UsersRepository usersRepository;
    
    @GetMapping(value="/users", produces = "application/json")
    public Map<String,Object> GetUsers(){
      HashMap<String,Object> response = new HashMap<>();
      response.put("responseCode", 200);
      response.put("users",usersRepository.findAll());
      return response;
    }
}
