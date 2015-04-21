/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;


import java.util.List;

import org.json.JSONArray;

import models.Doctor;

/**
 *
 * @author estudiante
 */
public interface IServicioDoctores
{
 public Doctor agregarDoctor(Doctor doctor) throws Exception;
 
 public JSONArray getDoctor(String id) throws Exception;
 
    public void eliminarDoctor(String id) throws Exception;
    
    public JSONArray getDoctores() throws Exception;   
}
