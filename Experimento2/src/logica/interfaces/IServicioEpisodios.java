/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import java.util.List;

import org.json.JSONArray;

import models.Episodio;

/**
 *
 * @author estudiante
 */
public interface IServicioEpisodios
{
    public Episodio agregarEpisodio(Episodio episodio) throws Exception;
 
    public JSONArray getEpisodio(String id) throws Exception;
    
    public void eliminarEpisodio(String id) throws Exception;
    
    public JSONArray getEpisodios() throws Exception;   
    
    public JSONArray getEpisodiosPaciente(String id) throws Exception;
}
