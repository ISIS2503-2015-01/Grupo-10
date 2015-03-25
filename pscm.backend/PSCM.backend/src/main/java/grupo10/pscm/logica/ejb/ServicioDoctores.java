/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.logica.ejb;

import grupo10.pscm.exceptions.OperacionFallidaException;
import grupo10.pscm.logica.interfaces.IServicioDoctores;
import grupo10.pscm.models.Doctor;
import grupo10.pscm.models.Episodio;
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
public class ServicioDoctores implements IServicioDoctores
{

  //  @EJB
  //  private ServicioPersistenciaMock persistencia;
    
    //@PersistenceContext(unitName = "mentalPU")
    EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    public ServicioDoctores() 
    {
       // persistencia = new ServicioPersistenciaMock();
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
    public Doctor agregarDoctor(Doctor doctor) throws Exception 
   {
        Doctor d = doctor;
        try 
        {
            entityManager.getTransaction().begin();
            entityManager.persist(d);
            entityManager.getTransaction().commit();
            entityManager.refresh(d);
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            d = null;
        } finally {
        	entityManager.clear();
        	entityManager.close();
        }
            
        return d;
    }

    
    public void eliminarDoctor(String id) throws Exception 
    {
        try
        {
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("DELETE FROM Doctor d WHERE d.id="+id);
            int deleted = q.executeUpdate();
            entityManager.getTransaction().commit();
        } 
        catch (Exception e)
        {
            throw new OperacionFallidaException("No se pudo eliminar el doctor deseado");
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    @Override
    public List<Doctor> getDoctores() 
    {
      Query q = entityManager.createQuery("select u from Doctor u order by u.id ASC");
      List<Doctor> doctores = q.getResultList();
        
        return doctores;
    }
    
     public void actualizarDoctor(Doctor doctor) throws Exception   
       {
           Doctor d=doctor;
        try
        {
            entityManager.getTransaction().begin();           
            entityManager.refresh(d);
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
    public Doctor getDoctor(String id) 
    {
        Query q = entityManager.createQuery("SELECT d FROM Doctor d WHERE d.id="+id+"");
        Doctor doctorcito = (Doctor) q.getSingleResult();
        return doctorcito;
    }
}
