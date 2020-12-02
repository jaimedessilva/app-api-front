package br.com.projeto.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * api-rest
 * @author jaime Des
 * Em: 29 de nov de 2020 **/

@Path("/hello")
public class Hello {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response hello () {
		
		String msg = "Hello World Rest Api";
		
		return Response.status(Status.OK).entity(msg).build();
	}

}
