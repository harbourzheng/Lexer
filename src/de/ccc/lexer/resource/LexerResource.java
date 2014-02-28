package de.ccc.lexer.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.ccc.lexer.craw.LexerCrawService;
import de.ccc.lexer.dao.LexerDataOperation;
import de.ccc.lexer.model.*;
 
@Path ("/lexer")
public class LexerResource {
	@GET
	@Path("/getByAddress/{address}")
	@Produces(MediaType.APPLICATION_JSON)
	    public List<Form> getJSONByAddress( @PathParam("address") String address ) {
	        List<Form> list = LexerDataOperation.getByAddress(address);
	        return list;
	    }
	@GET
	@Path("/getById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Form getJSONByID( @PathParam("id") String id ) {
	        Form rs = LexerDataOperation.getById(id);
	        return rs;
	}
	
	@GET
	@Path("/craw/{address}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean craw( @PathParam("address") String address ) {
	        LexerCrawService lexerSevervice = new LexerCrawService();
	     //   lexerSevervice.crawSite(address);
	        return true;
	}
 
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON() {
 
		String result = "Track saved : " + "";
		return Response.status(201).entity(result).build();
 
	}

}
