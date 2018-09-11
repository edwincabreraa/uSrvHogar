/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.service;

import ec.edu.ucuenca.MicroservicioHogar.RespuestaJSON;
import ec.edu.ucuenca.MicroservicioHogar.dao.ControladorDao;
import ec.edu.ucuenca.MicroservicioHogar.dao.DispositivoDao;
import ec.edu.ucuenca.MicroservicioHogar.dom.DispositivoHW;
import java.sql.SQLException;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 *
 * @author Paola
 */
@Service
public class ControladorService {
    @Autowired
    ControladorDao cDao;
    
    @Autowired
    DispositivoDao dDao;
    private static final Logger logger = Logger.getLogger(ControladorService.class.getName());

    public RespuestaJSON getDispositivos(String cedula ) throws SQLException {
        RespuestaJSON respuesta = new RespuestaJSON();
        Map lista=dDao.getEstadosDispsByPaciente(cedula);
        if(lista!=null){
            respuesta.setEstado(true);
            respuesta.setMensaje("los dispositivos son:");
            respuesta.setRespuesta(lista);
            return respuesta;
        }
        else{
            respuesta.setEstado(false);
            respuesta.setMensaje("No es usuario del sistema");
            respuesta.setRespuesta(false);
            return respuesta;
        }
       
    }
    /*public RespuestaJSON addDispositivo(){
        RespuestaJSON respuesta = new RespuestaJSON();
        boolean exists = cDao.isUser(idUsuario);

        if (exists == false) {
            respuesta.setEstado(false);
            respuesta.setMensaje("No es usuario del sistema");
            respuesta.setRespuesta(false);
            return respuesta;
        }
        return null;
    }*/

    
}
