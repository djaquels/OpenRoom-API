/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.utils;

/**
 *
 * @author hjaca
 */
public class CreateRoomRequest {
    private String roomName;
    private Integer roomCategoryId;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomCategoryId() {
        return roomCategoryId;
    }

    public void setRoomCategoryId(Integer roomCategoryId) {
        this.roomCategoryId = roomCategoryId;
    }
    
}
