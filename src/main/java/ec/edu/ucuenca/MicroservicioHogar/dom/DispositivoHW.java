/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.dom;

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

/**
 *
 * @author Paola
 */
@Entity
@Table(name = "dispositivohw")

public class DispositivoHW implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDispositivoHW")
    private Integer idDispositivoHW;
    @Column(name = "nombre", unique=true)
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "puertoFisico")
    private Integer puertoFisico;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "cedulaPaciente")
    private String cedulaPaciente;
    @JoinColumn(name = "controlador", referencedColumnName = "idControladorHogar")
    @ManyToOne
    private Controladorhogar controlador;

    public DispositivoHW(){
    }

    public DispositivoHW(Integer idDispositivoHW) {
        this.idDispositivoHW = idDispositivoHW;
    }

    public Integer getIdDispositivoHW() {
        return idDispositivoHW;
    }

    public void setIdDispositivoHW(Integer idDispositivoHW) {
        this.idDispositivoHW = idDispositivoHW;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPuertoFisico() {
        return puertoFisico;
    }

    public void setPuertoFisico(Integer puertoFisico) {
        this.puertoFisico = puertoFisico;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Controladorhogar getIdControlador() {
        return controlador;
    }

    public void setIdControlador(Controladorhogar idControlador) {
        this.controlador = idControlador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDispositivoHW != null ? idDispositivoHW.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DispositivoHW)) {
            return false;
        }
        DispositivoHW other = (DispositivoHW) object;
        if ((this.idDispositivoHW == null && other.idDispositivoHW != null) || (this.idDispositivoHW != null && !this.idDispositivoHW.equals(other.idDispositivoHW))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ucuenca.MicroservicioHogar.Dispositivohw[ idDispositivoHW=" + idDispositivoHW + " ]";
    }
    
}
