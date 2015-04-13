/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.servicios;

import grupo10.pscm.exceptions.OperacionFallidaException;
import grupo10.pscm.logica.ejb.ServicioPacientes;
import grupo10.pscm.models.Paciente;
import grupo10.pscm.models.PacienteDTO;
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
@Path("Pacientes")
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
        List<Paciente> pacientes = servPacientes.getPacientes();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(pacientes).build();
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaciente(@QueryParam("id") String code )
    {
        Paciente p = servPacientes.getPaciente(code);
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(p).build();
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPaciente(PacienteDTO paciente)
    {
        try
        {
            Paciente p = new Paciente(paciente.getNombre(), paciente.getApellido(), paciente.getTelefonoCelular(), paciente.getDocumento(), paciente.getTelefonoFijo(), paciente.getGenero(), paciente.getDireccion());
            servPacientes.agregarPaciente(p);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(p).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //TODO Check if this works
    }
    
    @PUT
    @Path("/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPaciente(PacienteDTO paciente)
    {
        try
        {
            Paciente p = new Paciente(paciente.getNombre(), paciente.getApellido(), paciente.getTelefonoCelular(), paciente.getDocumento(), paciente.getTelefonoFijo(), paciente.getGenero(), paciente.getDireccion());
            servPacientes.actualizarPaciente(p);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(p).build();
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
        //TODO not working, check why
        try
        {
            servPacientes.eliminarPaciente(code);
            servPacientes = new ServicioPacientes();
            List<Paciente> pacientes = servPacientes.getPacientes(); //TODO maybe delete this line
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(pacientes).build();
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