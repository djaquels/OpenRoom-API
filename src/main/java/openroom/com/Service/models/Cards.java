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
@NamedQueries({
    @NamedQuery(name = "Cards.findAll", query = "SELECT c FROM Cards c"),
    @NamedQuery(name = "Cards.findById", query = "SELECT c FROM Cards c WHERE c.id = :id"),
    @NamedQuery(name = "Cards.findByContent", query = "SELECT c FROM Cards c WHERE c.content = :content"),
    @NamedQuery(name = "Cards.findByUpvotes", query = "SELECT c FROM Cards c WHERE c.upvotes = :upvotes"),
    @NamedQuery(name = "Cards.findByDownvotes", query = "SELECT c FROM Cards c WHERE c.downvotes = :downvotes")})
public class Cards implements Serializable {

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
    private Rooms idRoom;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private Users idUser;
    @OneToMany(mappedBy = "idCard")
    private List<CardsComments> cardsCommentsList;

    public Cards() {
    }

    public Cards(Integer id) {
        this.id = id;
    }

    public Cards(Integer id, String content) {
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

    public Rooms getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Rooms idRoom) {
        this.idRoom = idRoom;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<CardsComments> getCardsCommentsList() {
        return cardsCommentsList;
    }

    public void setCardsCommentsList(List<CardsComments> cardsCommentsList) {
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
        if (!(object instanceof Cards)) {
            return false;
        }
        Cards other = (Cards) object;
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
