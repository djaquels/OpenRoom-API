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
@Table(name = "cards_comments", catalog = "openroom", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardsComments.findAll", query = "SELECT c FROM CardsComments c"),
    @NamedQuery(name = "CardsComments.findById", query = "SELECT c FROM CardsComments c WHERE c.id = :id"),
    @NamedQuery(name = "CardsComments.findByIsAnswer", query = "SELECT c FROM CardsComments c WHERE c.isAnswer = :isAnswer"),
    @NamedQuery(name = "CardsComments.findByContent", query = "SELECT c FROM CardsComments c WHERE c.content = :content")})
public class CardsComments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_answer")
    private Boolean isAnswer;
    @Column(name = "content_")
    private String content;
    @JoinColumn(name = "id_card", referencedColumnName = "id")
    @ManyToOne
    private Cards idCard;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private Users idUser;

    public CardsComments() {
    }

    public CardsComments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(Boolean isAnswer) {
        this.isAnswer = isAnswer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Cards getIdCard() {
        return idCard;
    }

    public void setIdCard(Cards idCard) {
        this.idCard = idCard;
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
        if (!(object instanceof CardsComments)) {
            return false;
        }
        CardsComments other = (CardsComments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.CardsComments[ id=" + id + " ]";
    }
    
}
