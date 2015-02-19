/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.ejb;

import grupo10.pscm.exceptions.OperacionFallidaException;
import grupo10.pscm.logica.interfaces.IServicioPacientes;
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
public class ServicioPacientes implements IServicioPacientes
{

    @EJB
    private ServicioPersistenciaMock persistencia;
    
    
    public ServicioPacientes()
    {
        persistencia = new ServicioPersistenciaMock();
    }
    
    //----------------------------
    //Metodos
    //----------------------------
    
    @Override
    public void agregarPaciente(Paciente paciente) throws Exception 
    {
        
        
        try
        {
            //if(paciente.getId()>0)
            //{
                persistencia.create(paciente);
            //}
           // else
            //{
               // throw new OperacionFallidaException("El número de documento no es válido");
            //}
        }
        catch (OperacionFallidaException ex)
        {
            throw new OperacionFallidaException(ex.getMessage());
        }
        
    }

    @Override
    public void eliminarPaciente(Long id) throws Exception 
    {
        Paciente p=(Paciente) persistencia.findById(Paciente.class, id);
        try
        {
            persistencia.delete(p);
        } 
        catch (OperacionFallidaException ex)
        {
            throw new OperacionFallidaException("No se pudo eliminar al paciente");
        }
         
    }

    @Override
    public List<Paciente> getPacientes() 
    {
       
        
        return persistencia.findAll(Paciente.class);
       
       
        
    }
    
    
    
    public void actualizarPaciente(Paciente paciente)
    {
        persistencia.update(paciente);
    }

    @Override
    public Paciente getPaciente(String id)
    {
        return (Paciente) persistencia.findById(Paciente.class, id);
    }
    
}
