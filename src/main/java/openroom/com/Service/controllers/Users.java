/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author hjaca
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import openroom.com.Service.repositories.UsersRepository;

@RestController
public class Users {
    @Autowired
    UsersRepository usersRepository;
    
    private Gson gson;

    @GetMapping("/users")
    public String GetUsers(){
      return "";
    }
}
