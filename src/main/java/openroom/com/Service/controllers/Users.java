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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Users {
    @Autowired
    UsersRepository usersRepository;
    
    @GetMapping(value="/users", produces = "application/json")
    public Map<String,Object> GetUsers() throws Exception {
      HashMap<String,Object> response = new HashMap<>();
      response.put("responseCode",  HttpStatus.FOUND);
      response.put("users",usersRepository.findAll());
      return response;
    }
    
    @GetMapping(value="/users/{id}", produces = "application/json")
    public Map<String,Object> GetUser(@RequestParam("id")Integer id) throws Exception{
        HashMap<String,Object> response = new HashMap<>();
        response.put("responseCode", HttpStatus.FOUND);
        response.put("user", usersRepository.findById(id));
        return response;
    }
}
