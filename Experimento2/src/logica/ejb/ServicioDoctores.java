/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import excepciones.OperacionFallidaException;
import logica.interfaces.IServicioDoctores;
import models.Doctor;
import models.Episodio;
import persistencia.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.JSONArray;

/**
 *
 * @author estudiante
 */
public class ServicioDoctores implements IServicioDoctores
{
	private PersistenceManager manager;

	public ServicioDoctores() 
	{
		manager = new PersistenceManager();
	}

	//----------------------------
	//Metodos
	//----------------------------


	@Override
	public Doctor agregarDoctor(Doctor doctor) throws Exception
	{	
		Doctor d;
		manager.persist(doctor);
		d = doctor;
		return d;
	}


	public void eliminarDoctor(String id) throws Exception 
	{
		manager.delete(Doctor.class, id);
	}

	@Override
	public JSONArray getDoctores() throws Exception 
	{
		return manager.getAll(Doctor.class);
	}

	public Doctor actualizarDoctor(Doctor doctor) throws Exception   
	{
		Doctor d;
		manager.update(doctor, doctor.getDocumento());
		d = doctor;
		return d;
	}        

	@Override
	public JSONArray getDoctor(String id) throws Exception 
	{
		return manager.getById(Doctor.class, id, "documento");
	}
}
