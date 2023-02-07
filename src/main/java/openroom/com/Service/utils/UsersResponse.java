/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

import java.io.Serializable;
import java.util.List;
import openroom.com.Service.models.UsersEntity;

/**
 *
 * @author hjaca
 */
public class UsersResponse extends ResponseFactory{
    
    private List<UsersEntity> users;
    
     @Override
     public Items createItem(){
       return new UserItems(this.users);
     }
     
     public UsersResponse(List<UsersEntity> result){
         this.users = result ;
     }
}
