/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hjaca
 */
@Entity
@Table(name = "rooms", catalog = "openroom", schema = "public")
@XmlRootElement
public class RoomsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "room_name")
    private String roomName;
    @JoinTable(name = "rooms_categories", joinColumns = {
        @JoinColumn(name = "id_room", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_category", referencedColumnName = "id")})
    @ManyToMany
    private List<RoomCategoryEntity> roomCategoryList;
    @OneToMany(mappedBy = "idRoom")
    private List<CardsEntity> cardsList;
    @OneToMany(mappedBy = "idRoom")
    private List<RoomsUsersEntity> roomsUsersList;

    public RoomsEntity() {
    }

    public RoomsEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @XmlTransient
    public List<RoomCategoryEntity> getRoomCategoryList() {
        return roomCategoryList;
    }

    public void setRoomCategoryList(List<RoomCategoryEntity> roomCategoryList) {
        this.roomCategoryList = roomCategoryList;
    }

    @XmlTransient
    public List<CardsEntity> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<CardsEntity> cardsList) {
        this.cardsList = cardsList;
    }

    @XmlTransient
    public List<RoomsUsersEntity> getRoomsUsersList() {
        return roomsUsersList;
    }

    public void setRoomsUsersList(List<RoomsUsersEntity> roomsUsersList) {
        this.roomsUsersList = roomsUsersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomsEntity)) {
            return false;
        }
        RoomsEntity other = (RoomsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Rooms[ id=" + id + " ]";
    }
    
}
