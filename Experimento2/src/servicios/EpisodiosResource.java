/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import logica.ejb.ServicioEpisodios;
import models.Episodio;
import models.EpisodioDTO;

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
@Path("episodios")
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
        
        try {
			return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servEpisodios.getEpisodios().toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.NO_CONTENT).build();
		}
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEpisodio(EpisodioDTO episodio)
    {
        try
        {
            Episodio e = new Episodio(episodio.getDocumentoPaciente(), episodio.getFechaEpisodio(), episodio.getNivelDolor(), episodio.getHora(), episodio.getPatronSueno(), episodio.getAlimentos(), episodio.getBebidas(), episodio.getActividadFisica(), episodio.getMedicamentos(),episodio.getLocalizacion(), episodio.getNotasMedico(), episodio.getPosiblesCausas());
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servEpisodios.actualizarEpisodio(e).toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GET
    @Path("/paciente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEpisodiosPaciente(@QueryParam("id") String code ) {
        try {
			return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servEpisodios.getEpisodiosPaciente(code).toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.NO_CONTENT).build();
		}
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEpisodio(@QueryParam("id") String code )
    {
        try {
			return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servEpisodios.getEpisodio(code).toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.NO_CONTENT).build();
		}
    }
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEpisodio(EpisodioDTO episodio)
    {
        try
        {
            Episodio e = new Episodio(episodio.getDocumentoPaciente(), episodio.getFechaEpisodio(), episodio.getNivelDolor(), episodio.getHora(), episodio.getPatronSueno(), episodio.getAlimentos(), episodio.getBebidas(), episodio.getActividadFisica(), episodio.getMedicamentos(), episodio.getLocalizacion(), episodio.getNotasMedico(), episodio.getPosiblesCausas());
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servEpisodios.agregarEpisodio(e).toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEpisodio(@QueryParam("id") String code )
    {
        try
        {
            servEpisodios.eliminarEpisodio(code);
            servEpisodios = new ServicioEpisodios();
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(servEpisodios.getEpisodios().toString()).build();
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
