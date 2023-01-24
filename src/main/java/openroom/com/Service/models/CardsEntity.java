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
import javax.persistence.ManyToOne;
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
@Table(name = "cards", catalog = "openroom", schema = "public")
@XmlRootElement
public class CardsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "content_")
    private String content;
    @Column(name = "upvotes")
    private Integer upvotes;
    @Column(name = "downvotes")
    private Integer downvotes;
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    @ManyToOne
    private RoomsEntity idRoom;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private UsersEntity idUser;
    @OneToMany(mappedBy = "idCard")
    private List<CardsCommentsEntity> cardsCommentsList;

    public CardsEntity() {
    }

    public CardsEntity(Integer id) {
        this.id = id;
    }

    public CardsEntity(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    public RoomsEntity getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(RoomsEntity idRoom) {
        this.idRoom = idRoom;
    }

    public UsersEntity getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersEntity idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<CardsCommentsEntity> getCardsCommentsList() {
        return cardsCommentsList;
    }

    public void setCardsCommentsList(List<CardsCommentsEntity> cardsCommentsList) {
        this.cardsCommentsList = cardsCommentsList;
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
        if (!(object instanceof CardsEntity)) {
            return false;
        }
        CardsEntity other = (CardsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Cards[ id=" + id + " ]";
    }
    
}
