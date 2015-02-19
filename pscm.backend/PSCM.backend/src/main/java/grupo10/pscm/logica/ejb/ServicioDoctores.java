/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.ejb;

import grupo10.pscm.exceptions.OperacionFallidaException;
import grupo10.pscm.logica.interfaces.IServicioDoctores;
import grupo10.pscm.models.Doctor;
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
public class ServicioDoctores implements IServicioDoctores
{

    @EJB
    private ServicioPersistenciaMock persistencia;
    
    
    //----------------------------
    //Metodos
    //----------------------------
    

    @Override
    public void agregarDoctor(Doctor doctor) throws Exception 
    {
         try
        {
            if(doctor.getNombre()!=null) //TODO check ID later
            {

            persistencia.create(doctor);
            }
            else
            {
                throw new OperacionFallidaException("El número de documento no es válido ó debe regitrar un nombre valido");
            }
        }
        catch (OperacionFallidaException ex)
        {
            throw new OperacionFallidaException(ex.getMessage());
        }
        
    }

    @Override
    public void eliminarDoctor(Long id) throws Exception 
    {
        Doctor doctor=(Doctor) persistencia.findById(Doctor.class, id);
        try
        {
            persistencia.delete(doctor);
        } 
        catch (OperacionFallidaException e)
        {
            throw new OperacionFallidaException("No se pudo eliminar el doctor");
        }
    }

    @Override
    public List<Doctor> getDoctores() 
    {
        return (ArrayList<Doctor>) persistencia.findAll(Doctor.class);
    }
    
     public void actualizarDoctor(Doctor doctor)
    {
        persistencia.update(this);
    }
}
