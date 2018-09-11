/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.dom;

import ec.edu.ucuenca.MicroservicioHogar.dom.DispositivoHW;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author Paola
 */
@Entity
@Table(name = "controladorhogar")


public class Controladorhogar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idControladorHogar")
    private Integer idControladorhogar;
    @Column(name = "ip")
    private String ip;
    @OneToMany(mappedBy = "controlador")
    private List<DispositivoHW> dispositivohwCollection;
    
    public Controladorhogar() {
    }

    public Controladorhogar(Integer idControladorHogar) {
        this.idControladorhogar = idControladorHogar;
    }

    public Integer getIdControladorHogar() {
        return idControladorhogar;
    }

    public void setIdControladorHogar(Integer idControladorHogar) {
        this.idControladorhogar = idControladorHogar;
    }
    public void addDispositivoHW(DispositivoHW d){
        this.dispositivohwCollection.add(d);
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<DispositivoHW> getDispositivohwCollection() {
        return dispositivohwCollection;
    }

    public void setDispositivohwCollection(List<DispositivoHW> dispositivohwCollection) {
        this.dispositivohwCollection = dispositivohwCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControladorhogar != null ? idControladorhogar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controladorhogar)) {
            return false;
        }
        Controladorhogar other = (Controladorhogar) object;
        if ((this.idControladorhogar == null && other.idControladorhogar != null) || (this.idControladorhogar != null && !this.idControladorhogar.equals(other.idControladorhogar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ucuenca.MicroservicioHogar.Controladorhogar[ idControladorHogar=" + idControladorhogar + " ]";
    }
    
}
