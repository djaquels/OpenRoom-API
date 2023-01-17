/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openroom.com.Service.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hjaca
 */
@Entity
@Table(name = "rooms_users", catalog = "openroom", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomsUsers.findAll", query = "SELECT r FROM RoomsUsers r"),
    @NamedQuery(name = "RoomsUsers.findById", query = "SELECT r FROM RoomsUsers r WHERE r.id = :id")})
public class RoomsUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    @ManyToOne
    private Rooms idRoom;
    @JoinColumn(name = "id_user_role", referencedColumnName = "id")
    @ManyToOne
    private UserRole idUserRole;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private Users idUser;

    public RoomsUsers() {
    }

    public RoomsUsers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rooms getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Rooms idRoom) {
        this.idRoom = idRoom;
    }

    public UserRole getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(UserRole idUserRole) {
        this.idUserRole = idUserRole;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof RoomsUsers)) {
            return false;
        }
        RoomsUsers other = (RoomsUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.RoomsUsers[ id=" + id + " ]";
    }
    
}
