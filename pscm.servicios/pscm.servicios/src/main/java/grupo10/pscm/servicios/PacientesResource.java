/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.servicios;

import grupo10.pscm.logica.ejb.ServicioPacientes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author estudiante
 */
@Path("getPacientes")
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
    @Produces("application/json")
    public String getJson() {
        //TODO convert to JSON
        return servPacientes.getPacientes().toString();
    }
    
    @GET
    @Path("/get")
    @Produces("application/json")
    public String getPaciente(@QueryParam("id") String code )
    {
        //TODO convert to JSON
        return servPacientes.getPaciente("id").toString();
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
