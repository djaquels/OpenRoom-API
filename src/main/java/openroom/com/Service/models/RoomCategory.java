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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hjaca
 */
@Entity
@Table(name = "room_category", catalog = "openroom", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomCategory.findAll", query = "SELECT r FROM RoomCategory r"),
    @NamedQuery(name = "RoomCategory.findById", query = "SELECT r FROM RoomCategory r WHERE r.id = :id"),
    @NamedQuery(name = "RoomCategory.findByCategoryName", query = "SELECT r FROM RoomCategory r WHERE r.categoryName = :categoryName")})
public class RoomCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "category_name")
    private String categoryName;
    @ManyToMany(mappedBy = "roomCategoryList")
    private List<Rooms> roomsList;

    public RoomCategory() {
    }

    public RoomCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @XmlTransient
    public List<Rooms> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Rooms> roomsList) {
        this.roomsList = roomsList;
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
        if (!(object instanceof RoomCategory)) {
            return false;
        }
        RoomCategory other = (RoomCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.RoomCategory[ id=" + id + " ]";
    }
    
}
