/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import excepciones.OperacionFallidaException;
import logica.interfaces.IServicioEpisodios;
import models.Doctor;
import models.Episodio;
import models.Paciente;
import persistencia.*;

import javax.persistence.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.EJB;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

/**
 *
 * @author estudiante
 */
public class ServicioEpisodios implements IServicioEpisodios
{

	private PersistenceManager manager;
	
	//----------------------------
	//Metodos
	//----------------------------

	public ServicioEpisodios()
	{
		manager = new PersistenceManager();
	}

	@Override
	public Episodio agregarEpisodio(Episodio episodio) throws Exception 
	{
		Episodio e;
		manager.persist(episodio);
		e = episodio;
		return e;
	}

	public void eliminarEpisodio(String id) throws Exception 
	{
		manager.delete(Episodio.class, id);
	}

	public Episodio actualizarEpisodio(Episodio episodio)throws Exception
	{
		Episodio e;
		manager.update(episodio, episodio.getId()+"");
		e = episodio;
		return e;
	}

	@Override
	public JSONArray getEpisodios() throws Exception 
	{
		return manager.getAll(Episodio.class);
	}

	@Override
	public JSONArray getEpisodio(String id)  throws Exception{

		return manager.getById(Episodio.class, id);
	}

	@Override
	public JSONArray getEpisodiosPaciente(String doc) throws Exception 
	{
		Connection connection = PersistenceManager.getConnection();
		
		Statement stmt = connection.createStatement();
		
		String query = "SELECT * FROM Episodios WHERE DOCUMENTOPACIENTE="+"'"+doc+"'" ;
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		return PersistenceManager.convertResultSetIntoJSON(rs);
		
	}


}
