/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.rep;

import ec.edu.ucuenca.MicroservicioHogar.dom.DispositivoHW;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paola
 */
@Repository
public interface DispositivoRep extends CrudRepository<DispositivoHW, Integer>{
    DispositivoHW findByNombre(String nombre);
    List<DispositivoHW> findAllByCedulaPaciente(String cedula);
    List<DispositivoHW> findByControlador_IdControladorhogar(Integer  idDisposoitivo);
}
