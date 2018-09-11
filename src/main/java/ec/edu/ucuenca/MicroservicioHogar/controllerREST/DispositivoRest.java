/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.controllerREST;

import ec.edu.ucuenca.MicroservicioHogar.RespuestaJSON;
import ec.edu.ucuenca.MicroservicioHogar.service.ControladorService;
import ec.edu.ucuenca.MicroservicioHogar.service.DispositivoService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Paola
 */

@RestController
public class DispositivoRest {
    @Autowired
    DispositivoService dsrv;
    @Autowired
    ControladorService usuarioSrv;
    private static final Logger logger = Logger.getLogger(DispositivoRest.class.getName());
    
    @RequestMapping(value = "/getDispositivo", method = RequestMethod.GET)
    public RespuestaJSON getDispositivo(@RequestParam Integer id) throws SQLException{
        RespuestaJSON respuesta = dsrv.getDispositivo(id);
        logger.log(Level.INFO, "Resultado /getDispositivo : ["+ respuesta.getMensaje() + "] --- Consulta: /get_nivel_curso?idCurso="+id);
        return respuesta;
    }
    
    @RequestMapping(value = "/getEstadoDispositivo", method = RequestMethod.GET)
    public RespuestaJSON getEstadoDispositivo(@RequestParam Integer id) throws SQLException{
        RespuestaJSON respuesta = dsrv.getEstadoDispositivo(id);
        logger.log(Level.INFO, "Resultado /getEstadoDispositivo: ["+ respuesta.getMensaje() + "] --- Consulta: /get_nivel_curso?idCurso="+id);
        return respuesta;
    }
    
    @RequestMapping(value = "/setEstadoDispositivo", method = RequestMethod.GET)
    public RespuestaJSON setEstadoDispositivo(@RequestParam Integer id, Boolean estado) throws SQLException, IOException{
        RespuestaJSON respuesta = dsrv.setEstadoDispositivo(id, estado);
        logger.log(Level.INFO, "Resultado /get_nivel_curso : ["+ respuesta.getMensaje() + "] --- Consulta: /get_nivel_curso?idCurso="+id);
        return respuesta;
    }
    //metodo consumido solo por la parte fisica
    @RequestMapping(value = "/cambiaEstadoDispositivoName", method = RequestMethod.GET)
    public RespuestaJSON cambiaEstadoDispositivo(@RequestParam Integer id) throws SQLException, IOException{
        RespuestaJSON respuesta = dsrv.cambiaEstadoDispositivo(id);
        logger.log(Level.INFO, "Resultado /get_nivel_curso: ["+ respuesta.getMensaje() + "] --- Consulta: /get_nivel_curso?idCurso="+id);
        return respuesta;
    }
    //metodo consumido solo por la parte fisica
    @RequestMapping(value = "/setEstadoDispositivoName", method = RequestMethod.GET)
    public RespuestaJSON setEstadoDispositivo(@RequestParam String id, Boolean estado) throws SQLException{
        RespuestaJSON respuesta = dsrv.setEstadoDispositivo(id, estado);
        logger.log(Level.INFO, "Resultado /get_nivel_curso : ["+ respuesta.getMensaje() + "] --- Consulta: /get_nivel_curso?idCurso="+id);
        return respuesta;
    }
    
    
    
    
}
