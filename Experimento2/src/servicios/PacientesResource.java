/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import excepciones.OperacionFallidaException;
import logica.ejb.ServicioPacientes;
import models.Paciente;
import models.PacienteDTO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author estudiante
 */
@Path("pacientes")
@Produces(MediaType.APPLICATION_JSON)
public class PacientesResource {

    @Context
    private UriInfo context;
    private ServicioPacientes servPacientes;

    /**
     * Creates a new instance of GetPacientesResource
     */
    public PacientesResource() {
        servPacientes = new ServicioPacientes();
    }

    /**
     * Retrieves representation of an instance of grupo10.pscm.servicios.GetPacientesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        try {
        	System.out.println("....");
			return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servPacientes.getPacientes().toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.NO_CONTENT).build();
		}
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaciente(@QueryParam("id") String code )
    {
        try {
			return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servPacientes.getPaciente(code).toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.NO_CONTENT).build();
		}
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPaciente(PacienteDTO paciente)
    {
        try
        {
            Paciente p = new Paciente(paciente.getNombre(), paciente.getApellido(), paciente.getTelefonoCelular(), paciente.getDocumento(), paciente.getTelefonoFijo(), paciente.getGenero(), paciente.getDireccion());
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servPacientes.agregarPaciente(p).toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPaciente(PacienteDTO paciente)
    {
        try
        {
            Paciente p = new Paciente(paciente.getNombre(), paciente.getApellido(), paciente.getTelefonoCelular(), paciente.getDocumento(), paciente.getTelefonoFijo(), paciente.getGenero(), paciente.getDireccion());
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servPacientes.actualizarPaciente(p).toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePaciente(@QueryParam("id") String code )
    {
        try
        {
            servPacientes.eliminarPaciente(code);
            servPacientes = new ServicioPacientes();
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servPacientes.getPacientes().toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * PUT method for updating or creating an instance of GetPacientesResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}