/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.controllers;

import com.smattme.requestvalidator.RequestValidator;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author hjaca
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import openroom.com.Service.models.UserRoleEntity;

import openroom.com.Service.repositories.UsersRepository;
import openroom.com.Service.repositories.UsersRolesRepository;
import openroom.com.Service.utils.ResponseFactory;
import openroom.com.Service.utils.UsersResponse;
import openroom.com.Service.utils.newUserRoleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Users {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersRolesRepository userRolesRepository;
    
    private ResponseFactory response;
    
    @GetMapping(value="/users", produces = "application/json")
    public Map<String,Object> GetUsers() throws Exception {
      this.response = new UsersResponse(usersRepository.findAll()); 
      return response.getResponse(HttpStatus.FOUND);
    }
    
    @GetMapping(value="/users/{id}", produces = "application/json")
    public Map<String,Object> GetUser(@RequestParam("id")Integer id) throws Exception{
        HashMap<String,Object> response = new HashMap<>();
        response.put("responseCode", HttpStatus.FOUND);
        response.put("user", usersRepository.findById(id));
        return response;
    }
    @PostMapping(value="users/roles/new", produces="application/json")
    public Map<Object,String> newUserRole(@RequestBody newUserRoleRequest request) throws Exception{
        HashMap<Object,String> response = new HashMap<>();
        HashMap<String,String> rules = new HashMap<>();
        rules.put("roleName","required");
        List<String> errors = RequestValidator.validate(request,rules);
        if(!errors.isEmpty()){
             throw new Exception(errors.toString());
        }
        UserRoleEntity newRole = new UserRoleEntity();
        newRole.setRoleName(request.getRoleName());
        userRolesRepository.save(newRole);
        response.put("message", "new user role created");
        return response;
    }
}
