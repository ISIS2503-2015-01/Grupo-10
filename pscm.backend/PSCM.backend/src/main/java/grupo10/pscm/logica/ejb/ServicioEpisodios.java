/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.ejb;

import grupo10.pscm.exceptions.OperacionFallidaException;
import grupo10.pscm.logica.interfaces.IServicioEpisodios;
import grupo10.pscm.models.Episodio;
import grupo10.pscm.models.Paciente;
import grupo10.pscm.persistencia.*;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.EJB;

/**
 *
 * @author estudiante
 */
@Stateful
public class ServicioEpisodios implements IServicioEpisodios
{

    @EJB
    private ServicioPersistenciaMock persistencia;
    
    
    //----------------------------
    //Metodos
    //----------------------------
    
    public ServicioEpisodios()
    {
        persistencia = new ServicioPersistenciaMock();
    }

    @Override
    public void agregarEpisodio(Episodio episodio) throws Exception 
    {
         try
        {
            //if(episodio.getId()>0)
            //{
                persistencia.create(episodio);
            //}
            //else
            //{
            //    throw new OperacionFallidaException("El número de documento no es válido ó debe regitrar un nombre valido");
            //}
        }
        catch (OperacionFallidaException ex)
        {
            throw new OperacionFallidaException(ex.getMessage());
        }
        
    }

  
    public void eliminarEpisodio(String id) throws Exception 
    {
        Episodio episodio=(Episodio) persistencia.findById(Episodio.class, id);
        try
        {
            persistencia.delete(episodio);
        } 
        catch (OperacionFallidaException e)
        {
            throw new OperacionFallidaException("No se pudo eliminar el doctor");
        }
    }

    @Override
    public List<Episodio> getEpisodios() 
    {
        return (ArrayList<Episodio>) persistencia.findAll(Episodio.class);
    }

    @Override
    public Episodio getEpisodio(String id) {
        return (Episodio) persistencia.findById(Episodio.class, id);
    }

    @Override
    public List<Episodio> getEpisodiosPaciente(String id) {
        Paciente p = (Paciente) persistencia.findById(Paciente.class, id);
        return p.getEpisodios();
    }
    
    
}
