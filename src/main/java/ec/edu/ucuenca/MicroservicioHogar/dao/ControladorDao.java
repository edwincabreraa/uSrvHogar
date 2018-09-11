/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.dao;

import ec.edu.ucuenca.MicroservicioHogar.dom.Controladorhogar;
import ec.edu.ucuenca.MicroservicioHogar.dom.DispositivoHW;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ec.edu.ucuenca.MicroservicioHogar.rep.*;
/**
 *
 * @author Paola
 */
@Repository
public class ControladorDao {
    @Autowired
    private ControladorRep crep;
    @Autowired
    private DispositivoRep drep;
  
    private static final Logger logger = Logger.getLogger(ControladorDao.class.getName());
     
    //helio: Recuperación de cursos
    public Controladorhogar getControlador(Integer idControl){
        return crep.findById(idControl).get();
    }
    
    //helio: Recuperación de niveles
    public DispositivoHW getDispositivo(Integer idDispositivo){
        return drep.findById(idDispositivo).get();
    }
    
    //Consulta la existencia de un controlador en la base de datos
    public boolean hasControlador(Integer idCont) throws SQLException {
        Controladorhogar c = crep.findById(idCont).get();
        if(c == null){
            return false;
        }else{
            return true;
        }
    }  
    
    //Consulta la existencia de un nivel en la base de datos
    public boolean hasDispositivo(Integer idDisp) throws SQLException {
        DispositivoHW d = drep.findById(idDisp).get();
        if(d == null){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean addDispositivo(Integer idControlador, Integer idDispositivo){
        Controladorhogar c = crep.findById(idControlador).get();
        DispositivoHW d = drep.findById(idDispositivo).get();
        c.addDispositivoHW(d);
        crep.save(c);
        return true;
    }
    public List<DispositivoHW> DispositivosByControlador(Integer idControlador){
        logger.log(Level.SEVERE, idControlador.toString());
        Controladorhogar c=crep.findById(idControlador).get();
        return c.getDispositivohwCollection();
    }
   
}
