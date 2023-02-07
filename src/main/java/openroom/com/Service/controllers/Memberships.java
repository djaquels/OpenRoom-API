/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.controllers;

import com.smattme.requestvalidator.RequestValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import openroom.com.Service.models.RoomsEntity;
import openroom.com.Service.models.RoomsUsersEntity;
import openroom.com.Service.models.UserRoleEntity;
import openroom.com.Service.models.UsersEntity;
import openroom.com.Service.repositories.RoomsRepository;
import openroom.com.Service.repositories.RoomsUsersRepository;
import openroom.com.Service.repositories.UsersRepository;
import openroom.com.Service.repositories.UsersRolesRepository;
import openroom.com.Service.utils.joinRoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hjaca
 */
@RestController
public class Memberships {
    @Autowired
    private RoomsUsersRepository roomsUsersRepository;
    @Autowired
    private RoomsRepository roomsRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UsersRolesRepository  userRoleRepository;
    
    @GetMapping(value="/roomsMembers", produces="application/json")
    public Map<Object,String> getListRoomsMembers(@RequestParam Integer idRoom ){
        Map<Object,String> response = new HashMap<>();
        return response;
    }
    @PostMapping(value="/roomsMembers/join", produces="application/json")
    public Map<Object,String> joinRoom(@RequestBody joinRoomRequest request) throws Exception{
        Map<Object,String> response = new HashMap<>();
        Map<String,String> rules = new HashMap<>();
        rules.put("idRoom", "required");
        rules.put("idUser","required");
        rules.put("idUserRole", "required");
        List<String> errors = RequestValidator.validate(request,rules);
        if(!errors.isEmpty()){
             throw new Exception(errors.toString());
        }
        Optional<RoomsEntity> room = roomsRepository.findById(request.getIdRoom());
        Optional<UsersEntity> user = usersRepository.findById(request.getIdUser());
        Optional<UserRoleEntity> userRole = userRoleRepository.findById(request.getIdUserRole());
        RoomsUsersEntity newMembership = new RoomsUsersEntity();
        newMembership.setIdRoom(room.get());
        newMembership.setIdUser(user.get());
        newMembership.setIdUserRole(userRole.get());
        roomsUsersRepository.save(newMembership);
        response.put("message", "User joined room successfully");
        return response;
    }
    
}
