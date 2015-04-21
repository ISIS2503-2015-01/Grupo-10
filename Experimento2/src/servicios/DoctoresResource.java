/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import logica.ejb.ServicioDoctores;
import models.Doctor;
import models.DoctorDTO;

import java.util.List;

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
@Path("doctores")
@Produces(MediaType.APPLICATION_JSON)
public class DoctoresResource {

    @Context
    private UriInfo context;
    private ServicioDoctores servDoctores;
    
    /**
     * Creates a new instance of DoctoresResource
     */
    public DoctoresResource() {
        servDoctores = new ServicioDoctores();
    }

    /**
     * Retrieves representation of an instance of grupo10.pscm.servicios.DoctoresResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        
    	try 
    	{
    		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servDoctores.getDoctores().toString()).build();
    	} catch (Exception e) {

    		e.printStackTrace();
    		return Response.status(Response.Status.NO_CONTENT).build();
    	}
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctor(@QueryParam("id") String code )
    {
        
        try {
			return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servDoctores.getDoctor(code).toString()).build();
		} catch (Exception e) {
			
			e.printStackTrace();
			return Response.status(Response.Status.NO_CONTENT).build();
		}
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDoctor(DoctorDTO doctor)
    {
        try
        {
            Doctor d = new Doctor(doctor.getNombre(), doctor.getApellido(), doctor.getContrasena(), doctor.getDocumento(), doctor.getTelefonoC());
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servDoctores.agregarDoctor(d).toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editDoctor(DoctorDTO doctor)
    {
        try
        {
            Doctor d = new Doctor(doctor.getNombre(), doctor.getApellido(), doctor.getContrasena(), doctor.getDocumento(), doctor.getTelefonoC());
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servDoctores.actualizarDoctor(d).toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDoctor(@QueryParam("id") String code )
    {
        try
        {
            servDoctores.eliminarDoctor(code);
            servDoctores = new ServicioDoctores();
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servDoctores.getDoctores().toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of DoctoresResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
