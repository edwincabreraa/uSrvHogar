/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.controllerREST;

import ec.edu.ucuenca.MicroservicioHogar.RespuestaJSON;
import ec.edu.ucuenca.MicroservicioHogar.service.ControladorService;
import java.sql.SQLException;
import java.util.logging.Level;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Paola
 */
public class ControladorRest {
    @Autowired
    ControladorService cSrv;
    private static final Logger logger = Logger.getLogger(DispositivoRest.class.getName());
    @RequestMapping(value = "/getDispositivos", method = RequestMethod.GET)
    public RespuestaJSON getDispositivos(@RequestParam String cedula) throws SQLException{
        RespuestaJSON respuesta = cSrv.getDispositivos(cedula);
        logger.log(Level.INFO, "Resultado /getDispositivo : ["+ respuesta.getMensaje() + "] --- Consulta: /get_nivel_curso?idCurso="+cedula);
        return respuesta;
    }
}
