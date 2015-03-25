/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo10.pscm.servicios;

import grupo10.pscm.logica.ejb.ServicioEpisodios;
import grupo10.pscm.models.Episodio;
import grupo10.pscm.models.EpisodioDTO;
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
@Path("Episodios")
@Produces(MediaType.APPLICATION_JSON)
public class EpisodiosResource {

    @Context
    private UriInfo context;
    
    private ServicioEpisodios servEpisodios;

    /**
     * Creates a new instance of EpisodiosResource
     */
    public EpisodiosResource() {
        servEpisodios = new ServicioEpisodios();
    }

    /**
     * Retrieves representation of an instance of grupo10.pscm.servicios.EpisodiosResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        List<Episodio> episodios = servEpisodios.getEpisodios();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(episodios).build();
    }

    @GET
    @Path("/paciente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEpisodiosPaciente(@QueryParam("id") String code ) {
        List<Episodio> episodios = servEpisodios.getEpisodiosPaciente(code);
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(episodios).build();
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaciente(@QueryParam("id") String code )
    {
        Episodio e = servEpisodios.getEpisodio(code);
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(e).build();
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEpisodio(EpisodioDTO episodio)
    {
        try
        {
            Episodio e = new Episodio(episodio.getFechaEpisodio(), episodio.getNivelDolor(), episodio.getHora(), episodio.getPatronSueno(), episodio.getAlimentos(), episodio.getBebidas(), episodio.getActividadFisica(), episodio.getMedicamentos());
            servEpisodios.agregarEpisodio(e);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(e).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //TODO Check if this works
    }
    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePaciente(@QueryParam("id") String code )
    {
        try
        {
            servEpisodios.eliminarEpisodio(code);
            List<Episodio> episodios = servEpisodios.getEpisodios();
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(episodios).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
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
