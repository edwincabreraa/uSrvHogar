/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.dom;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Paola
 */
@Entity
public class Controlador {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="controlador_seq")
    @SequenceGenerator(name="controlador_seq", sequenceName="cntrolador_seq")
    private Long idControlador;
    @OneToMany(mappedBy="controlador")
    private List<DispositivoHW> dispositivosHW = new ArrayList<>();

    public Controlador() {
    }
    
    
    public Long getIdControlador() {
        return idControlador;
    }

    public void setIdControlador(Long idControlador) {
        this.idControlador = idControlador;
    }

    public List<DispositivoHW> getDispositivosHW() {
        return dispositivosHW;
    }

    public void setDispositivosHW(List<DispositivoHW> dispositivosHW) {
        this.dispositivosHW = dispositivosHW;
    }
    
    public void addDispositivoHW(DispositivoHW disp){
        this.dispositivosHW.add(disp);
    }
    
   
    
}
