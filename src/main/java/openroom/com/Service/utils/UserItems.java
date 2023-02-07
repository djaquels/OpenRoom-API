/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

import java.util.ArrayList;
import java.util.List;
import openroom.com.Service.models.UsersEntity;

/**
 *
 * @author hjaca
 */
public class UserItems implements Items {
    
    private List<UsersEntity> users;

    @Override
    public List<ItemResponse> getItems() {
        List<ItemResponse> resources = new ArrayList<>();
        for(UsersEntity user: users){
            ItemResponse data = new ItemResponse();
            data.addKeyValuePair("user_email", user.getEmail());
            data.addKeyValuePair("user_name", user.getUserName());
            data.addKeyValuePair("user_photo_url", user.getProfilePhotoUrl());
            resources.add(data);
        }
        return resources;
    }
    
    public  UserItems(List<UsersEntity> users){
        this.users = users;
    }
    
}
