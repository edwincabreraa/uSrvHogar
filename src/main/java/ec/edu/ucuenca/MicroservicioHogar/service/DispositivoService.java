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
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paola
 */
@Service
public class DispositivoService {
    @Autowired
    DispositivoDao dDao;
    @Autowired
    ControladorDao cDao;
    
    public RespuestaJSON getDispositivo(Integer idDisp){
        RespuestaJSON respuesta = new RespuestaJSON();
        DispositivoHW exists = dDao.getDispositivo(idDisp);

        if (exists == null) {
            respuesta.setEstado(false);
            respuesta.setMensaje("No es dispositivo del sistema");
            respuesta.setRespuesta(false);
            return respuesta;
        }
        else{
            respuesta.setEstado(true);
            respuesta.setMensaje("Éxito");
            respuesta.setRespuesta(exists);
            return respuesta;
        }
    }
    
    public RespuestaJSON getEstadoDispositivo(Integer idDisp){
        RespuestaJSON respuesta = new RespuestaJSON();
        DispositivoHW exists = dDao.getDispositivo(idDisp);

        if (exists == null) {
            respuesta.setEstado(false);
            respuesta.setMensaje("No es dispositivo del sistema");
            respuesta.setRespuesta(false);
            return respuesta;
        }
        else{
            respuesta.setEstado(true);
            respuesta.setMensaje("Éxito");
            respuesta.setRespuesta(exists.getEstado());
            return respuesta;
        }
    }
    
    public RespuestaJSON setEstadoDispositivo(Integer idDisp,Boolean estado) throws IOException{
        RespuestaJSON respuesta = new RespuestaJSON();
        Boolean exists =null;
        exists=dDao.setEstadoDisp(idDisp, estado);
        if (exists== null | exists==false) {
            respuesta.setEstado(false);
            respuesta.setMensaje("No es dispositivo del sistema");
            respuesta.setRespuesta(false);
            return respuesta;
        }
        else{
            respuesta.setEstado(true);
            respuesta.setMensaje("Éxito");
            respuesta.setRespuesta(exists);
            return respuesta;
        }
    }
    public RespuestaJSON cambiaEstadoDispositivo(Integer idDisp) throws IOException{
        RespuestaJSON respuesta = new RespuestaJSON();
        Boolean estate= null;
        
        estate = dDao.cambiaEstadoDisp(idDisp);

        if (estate == null | estate==false) {
            respuesta.setEstado(false);
            respuesta.setMensaje("No es dispositivo del sistema");
            respuesta.setRespuesta(false);
            return respuesta;
        }
        else{
            respuesta.setEstado(true);
            respuesta.setMensaje("Éxito");
            respuesta.setRespuesta(true);
            return respuesta;
        }
    }
    public RespuestaJSON setEstadoDispositivo(String idDisp,Boolean estado){
        RespuestaJSON respuesta = new RespuestaJSON();
        Boolean estate= null;
        estate = dDao.setEstadoDisp(idDisp,estado);

        if (estate == null | estate==false) {
            respuesta.setEstado(false);
            respuesta.setMensaje("No es dispositivo del sistema");
            respuesta.setRespuesta(false);
            return respuesta;
        }
        else{
            respuesta.setEstado(true);
            respuesta.setMensaje("Éxito");
            respuesta.setRespuesta(true);
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
