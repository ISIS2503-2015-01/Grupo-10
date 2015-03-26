/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.ejb;

import grupo10.pscm.exceptions.OperacionFallidaException;
import grupo10.pscm.logica.interfaces.IServicioPacientes;
import grupo10.pscm.models.Doctor;
import grupo10.pscm.models.Episodio;
import grupo10.pscm.models.Paciente;
import grupo10.pscm.persistencia.*;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author estudiante
 */
@Stateful
public class ServicioPacientes implements IServicioPacientes
{

   // @EJB
   // private ServicioPersistenciaMock persistencia;
    
    //@PersistenceContext(unitName = "mentalPU")
    EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    public ServicioPacientes()
    {
       //  persistencia = new ServicioPersistenciaMock();
//        try {
//            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    //----------------------------
    //Metodos
    //----------------------------
    
    @Override
    public Paciente agregarPaciente(Paciente paciente) throws Exception 
    {       
//        try
//        {
//            entityManager.persist(paciente);
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       Paciente p = paciente;
        try 
        {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
            entityManager.refresh(p);
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            p = null;
        } finally {
        	entityManager.clear();
        	entityManager.close();
        }          
           return paciente;
    }

    
    public void eliminarPaciente(String id) throws Exception 
    {
       try
        {
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("DELETE FROM Paciente p WHERE p.id="+id);
            int deleted = q.executeUpdate();
            entityManager.getTransaction().commit();
        } 
        catch (Exception e)
        {
            throw new OperacionFallidaException("No se pudo eliminar el pacientirijillo");
        } finally {
            entityManager.clear();
            entityManager.close();
        }
         
    }

    @Override
    public List<Paciente> getPacientes() 
    {
        Query q = entityManager.createQuery("select u from Paciente u order by u.id ASC");
        List<Paciente> pacientes = q.getResultList();
        
        return pacientes;
    }
    
    public void actualizarPaciente(Paciente paciente)throws Exception
    {
       Paciente p=paciente;
        try
        {
            entityManager.getTransaction().begin();           
            entityManager.refresh(p);
            entityManager.getTransaction().commit();
        } 
        catch (Exception e)
        {
            throw new OperacionFallidaException("No se pudo actualizar al doctor ");
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }        
    

    @Override
    public Paciente getPaciente(String id)
    {
        Query q = entityManager.createQuery("SELECT p FROM Paciente p WHERE p.id="+id+"");
        Paciente p = (Paciente) q.getSingleResult();
        return p;
    }
    
}
