/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.servicios;

import grupo10.pscm.logica.ejb.ServicioEpisodios;
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
@Path("Episodios")
public class EpisodiosResource {

    @Context
    private UriInfo context;
    
    private ServicioEpisodios servEpisodios;

    /**
     * Creates a new instance of EpisodiosResource
     */
    public EpisodiosResource() {
    }

    /**
     * Retrieves representation of an instance of grupo10.pscm.servicios.EpisodiosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        return servEpisodios.getEpisodios().toString();
    }

    @GET
    @Path("/get")
    @Produces("application/json")
    public String getPaciente(@QueryParam("id") String code )
    {
        //TODO convert to JSON
        return servEpisodios.getEpisodio("id").toString();
    }
    
    /**
     * PUT method for updating or creating an instance of EpisodiosResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
