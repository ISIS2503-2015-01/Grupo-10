package servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import persistencia.PersistenceManager;



@Path("/test")
public class TestService {

	@GET
	@Path("/simpleTest")
	public Response testService(){

		String res = "plop";
		return Response.status(200).entity(res).build();
	}

	@GET
	@Path("/deleteTablaEps")
	public Response testDelete(){
		try
		{
			String res = "plop";
			Connection con = PersistenceManager.getConnection();
			Statement stmt = con.createStatement();
			String delete = "DROP TABLE Episodios";
			stmt.executeUpdate(delete);
			return Response.status(200).entity(res).build();
		} catch (Exception e){
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

}
