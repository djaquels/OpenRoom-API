/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package openroom.com.Service.repositories;

import openroom.com.Service.models.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hjaca
 */
@Repository
public interface UsersRolesRepository extends JpaRepository<UserRoleEntity,Integer>{
    
}
