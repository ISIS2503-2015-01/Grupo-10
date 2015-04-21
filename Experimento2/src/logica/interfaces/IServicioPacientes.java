/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import models.Paciente;

import java.util.List;

import javax.ejb.Local;

import org.json.JSONArray;

/**
 *
 * @author estudiante
 */
@Local
public interface IServicioPacientes {
    
    public Paciente agregarPaciente(Paciente paciente) throws Exception;
    
    public JSONArray getPaciente(String id) throws Exception;
    
    public void eliminarPaciente (String id) throws Exception;
    
    public JSONArray getPacientes() throws Exception;
    
}
