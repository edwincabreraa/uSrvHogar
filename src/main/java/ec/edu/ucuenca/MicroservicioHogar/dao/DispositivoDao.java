/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ucuenca.MicroservicioHogar.dao;

import ec.edu.ucuenca.MicroservicioHogar.dom.DispositivoHW;
import ec.edu.ucuenca.MicroservicioHogar.rep.DispositivoRep;
import java.sql.SQLException;
import java.util.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URL;
import java.net.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author Paola
 */
@Repository
public class DispositivoDao {
    @Autowired
    private DispositivoRep drep;
    
    private static final Logger logger = Logger.getLogger(DispositivoDao.class.getName());
     
    public DispositivoHW getDispositivo(Integer idDisp){
        return drep.findById(idDisp).get();
    }
   /* public String ejecutarConsulta(HttpMethod method, String url, HttpHeaders headers, Paramet<String> clase) throws Exception {
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            try {
                String response = restTemplate.exchange(url,method,entity, clase.class.getBody);
                return response;
            }catch (HttpClientErrorException e) {
                String statusCode = e.getStatusCode().toString();
                if(statusCode.equals("401")){
                    return null;
                }else{
                    return null;
                }
            } catch (ResourceAccessException e){
                return null;
            }
        }*/
    public boolean setEstadoDisp(Integer idDisp, Boolean estado ) throws IOException{
        DispositivoHW d=drep.findById(idDisp).get();
        RestTemplate restTemplate = new RestTemplate();
        if(d!=null){
            d.setEstado(estado);
            
            String accion="";
            if(estado==true){
                accion="On";
            }else accion="Off";
            String url1="http://192.168.43.94:5005/activaDesactivaDispositivo/?puerto="+d.getNombre().toString()+"&accion="+accion.toString();
            System.out.println("url:" + url1);
            URL url;
            try {
                url = new URL(url1);
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode()!=200){
                    return false;
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(DispositivoDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            drep.save(d);
            return true;
        }
        return false;
    }
    public boolean setEstadoDisp(String idDisp, Boolean estado ){
        DispositivoHW d=drep.findByNombre(idDisp);
        if(d!=null){
            d.setEstado(estado);
            drep.save(d);
            return true;
        }
        return false;
    }
    public boolean cambiaEstadoDisp1(Integer idDisp ){
        DispositivoHW d=drep.findById(idDisp).get();
        if(d!=null){
            if(d!=null){
            if(d.getEstado()==true){
                d.setEstado(false);
                drep.save(d);
                return true;
            }else{
                d.setEstado(true);
                 drep.save(d);
                return true;
            }
        }}
        return false;
    }
    public boolean cambiaEstadoDisp(Integer idDisp ) throws IOException{
        DispositivoHW d=drep.findById(idDisp).get();
        RestTemplate restTemplate = new RestTemplate();
        if(d!=null){
            Boolean estado=false;
            if(d.getEstado()==true){
                d.setEstado(false);
                estado=true;
            }else{
                d.setEstado(true);
                estado=false;
            }
            
            String accion="";
            if(estado==true){
                accion="On";
            }else accion="Off";
            String url1="http://192.168.43.94:5005/activaDesactivaDispositivo/?puerto="+d.getNombre().toString()+"&accion="+accion.toString();
            System.out.println("url:" + url1);
            URL url;
            try {
                url = new URL(url1);
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode()!=200){
                    return false;
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(DispositivoDao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            drep.save(d);
            return true;
        }
        return false;
    }
   
    public Boolean getEstadoDisp(Integer idDisp ){
        DispositivoHW d=drep.findById(idDisp).get();
        if(d!=null){
            return d.getEstado(); 
        }
        return null;
    }
    
    public Map<Integer, Boolean> getEstadosDispsByPaciente(String cedula){
        List<DispositivoHW> ds=drep.findAllByCedulaPaciente(cedula);
        Map lista=new HashMap<Integer, Boolean>();
        if(ds!=null){
            for (DispositivoHW d : ds) {
                lista.put(d.getIdDispositivoHW(), d.getEstado());
            }
            return lista;
        }
        return null;
    }
    
    //Consulta la existencia de un curso en la base de datos
    public boolean hasDispositivo(Integer idDispositivo) throws SQLException {
        DispositivoHW c = drep.findById(idDispositivo).get();
        if(c == null){
            return false;
        }else{
            return true;
        }
    }
    
    
    
    
    
}
