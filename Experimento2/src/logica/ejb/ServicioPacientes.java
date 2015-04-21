/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import excepciones.OperacionFallidaException;
import logica.interfaces.IServicioPacientes;
import models.Doctor;
import models.Episodio;
import models.Paciente;
import persistencia.*;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.JSONArray;

import com.mongodb.util.JSON;

/**
 *
 * @author estudiante
 */
public class ServicioPacientes implements IServicioPacientes
{

	private PersistenceManager manager;

	public ServicioPacientes()
	{
		manager = new PersistenceManager();
	}

	//----------------------------
	//Metodos
	//----------------------------

	@Override
	public Paciente agregarPaciente(Paciente paciente) throws Exception 
	{       
		Paciente p;
		manager.persist(paciente);
		p = paciente;
		return p;
	}

	public void eliminarPaciente(String id) throws Exception 
	{
		manager.delete(Episodio.class, id);
	}

	@Override
	public JSONArray getPacientes() throws Exception 
	{
		System.out.println("----");
		return manager.getAll(Paciente.class);
	}

	public Paciente actualizarPaciente(Paciente paciente)throws Exception
	{
		Paciente p;
		manager.update(paciente, paciente.getDocumento()+"");
		p = paciente;
		return p;
	}        


	@Override
	public JSONArray getPaciente(String id) throws Exception
	{
		return manager.getById(Paciente.class, id, "documento");
	}

}
