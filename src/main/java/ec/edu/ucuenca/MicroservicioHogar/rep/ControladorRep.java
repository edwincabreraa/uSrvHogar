/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.rep;

import ec.edu.ucuenca.MicroservicioHogar.dom.Controladorhogar;
import ec.edu.ucuenca.MicroservicioHogar.dom.DispositivoHW;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
/**
 *
 * @author Paola
 */
public interface ControladorRep extends CrudRepository<Controladorhogar, Integer>{
   //Controlador findOneByCedulaPaciente(Integer id);
}
