/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "tipo_de_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeMaterial.findAll", query = "SELECT t FROM TipoDeMaterial t")
    , @NamedQuery(name = "TipoDeMaterial.findById", query = "SELECT t FROM TipoDeMaterial t WHERE t.id = :id")
    , @NamedQuery(name = "TipoDeMaterial.findByTipoMaterial", query = "SELECT t FROM TipoDeMaterial t WHERE t.tipoMaterial = :tipoMaterial")})
public class TipoDeMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipoMaterial")
    private String tipoMaterial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDeMaterial")
    private List<Reciclaje> reciclajeList;

    public TipoDeMaterial() {
    }

    public TipoDeMaterial(Integer id) {
        this.id = id;
    }

    public TipoDeMaterial(Integer id, String tipoMaterial) {
        this.id = id;
        this.tipoMaterial = tipoMaterial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    @XmlTransient
    @JsonIgnore
    public List<Reciclaje> getReciclajeList() {
        return reciclajeList;
    }

    public void setReciclajeList(List<Reciclaje> reciclajeList) {
        this.reciclajeList = reciclajeList;
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
        if (!(object instanceof TipoDeMaterial)) {
            return false;
        }
        TipoDeMaterial other = (TipoDeMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoDeMaterial[ id=" + id + " ]";
    }
    
}
