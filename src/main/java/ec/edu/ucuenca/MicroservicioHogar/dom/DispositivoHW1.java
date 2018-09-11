/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.dom;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Paola
 */
@Entity
public class DispositivoHW1 {
    @Id
    @GeneratedValue
    private Long idDispositivoHW;
    private String nombre;
    private String tipo;
    private Boolean estado;
    private Integer puerto;
    private String cedulaPaciente;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="controladorID")
    private Controlador controlador;

    public DispositivoHW1(String nombre, String tipo, Boolean estado, Integer puerto, String cedulaPaciente, Controlador cont) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.puerto = puerto;
        this.cedulaPaciente = cedulaPaciente;
        this.controlador=cont;
    }
    
    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    public Long getIdDispositivoHW() {
        return idDispositivoHW;
    }

    public void setIdDispositivoHW(Long idDispositivoHW) {
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getPuerto() {
        return puerto;
    }

    public void setPuerto(Integer puerto) {
        this.puerto = puerto;
    }
    
    
            
}
