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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hjaca
 */
@Entity
@Table(name = "users", catalog = "openroom", schema = "public")
@XmlRootElement
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "profile_photo_url")
    private String profilePhotoUrl;
    @OneToMany(mappedBy = "idUser")
    private List<CardsEntity> cardsList;
    @OneToMany(mappedBy = "idUser")
    private List<CardsCommentsEntity> cardsCommentsList;
    @OneToMany(mappedBy = "idUser")
    private List<RoomsUsersEntity> roomsUsersList;

    public UsersEntity() {
    }

    public UsersEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    @XmlTransient
    public List<CardsEntity> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<CardsEntity> cardsList) {
        this.cardsList = cardsList;
    }

    @XmlTransient
    public List<CardsCommentsEntity> getCardsCommentsList() {
        return cardsCommentsList;
    }

    public void setCardsCommentsList(List<CardsCommentsEntity> cardsCommentsList) {
        this.cardsCommentsList = cardsCommentsList;
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
        if (!(object instanceof UsersEntity)) {
            return false;
        }
        UsersEntity other = (UsersEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Users[ id=" + id + " ]";
    }
    
}
