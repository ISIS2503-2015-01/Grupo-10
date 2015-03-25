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
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.EJB;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

/**
 *
 * @author estudiante
 */
@Stateful
public class ServicioEpisodios implements IServicioEpisodios
{

//    @EJB
//    private ServicioPersistenciaMock persistencia;
    
    //@PersistenceContext(unitName = "mentalPU")
    EntityManager entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    //----------------------------
    //Metodos
    //----------------------------
    
    public ServicioEpisodios()
    {
        //persistencia = new ServicioPersistenciaMock();
//        try {
//            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Episodio agregarEpisodio(Episodio episodio) throws Exception 
    {
        Episodio e = episodio;
        try 
        {
            entityManager.getTransaction().begin();
            entityManager.persist(e);
            entityManager.getTransaction().commit();
            entityManager.refresh(e);
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e = null;
        } finally {
        	entityManager.clear();
        	entityManager.close();
        }
            
        return e;
    }

  
    public void eliminarEpisodio(String id) throws Exception 
    {
        try
        {
            entityManager.getTransaction().begin();
            Query q = entityManager.createQuery("DELETE FROM Episodio e WHERE e.id="+id);
            int deleted = q.executeUpdate();
            entityManager.getTransaction().commit();
        } 
        catch (Exception e)
        {
            throw new OperacionFallidaException("No se pudo eliminar el episodio");
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }
    
    public void actualizarEpisodio(Episodio episodio)throws Exception
    {
       Episodio ep=episodio;
        try
        {
            entityManager.getTransaction().begin();           
            entityManager.refresh(ep);
            entityManager.getTransaction().commit();
        } 
        catch (Exception e)
        {
            throw new OperacionFallidaException("No se pudo actualizar el episodio ");
        } finally {
            entityManager.clear();
            entityManager.close();
        }
    }

    @Override
    public List<Episodio> getEpisodios() 
    {
        Query q = entityManager.createQuery("select u from Episodio u order by u.id ASC");
        List<Episodio> episodios = q.getResultList();
        
        return episodios;
    }

    @Override
    public Episodio getEpisodio(String id) {
        
        Query q = entityManager.createQuery("SELECT e FROM Episodio e WHERE e.id="+id+"");
        Episodio ep = (Episodio) q.getSingleResult();
        return ep;
    }

    @Override
    public List<Episodio> getEpisodiosPaciente(String id) {
        Query q = entityManager.createQuery("SELECT e FROM Episodio e WHERE e.idPaciente="+id+"");
        List<Episodio> episodios = q.getResultList();
        return episodios;
    }
    
    
}
