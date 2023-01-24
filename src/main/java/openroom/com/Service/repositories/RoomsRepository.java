/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package openroom.com.Service.repositories;

import openroom.com.Service.models.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hjaca
 */
@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
    
}
