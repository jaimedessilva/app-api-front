package br.com.projeto.rest.controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import br.com.projeto.dao.RepositoryDao;
import br.com.projeto.domain.Usuario;

/**
 * api-rest
 * @author jaime Des
 * Em: 28 de nov de 2020 **/

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestController {
	
	RepositoryDao repository = new RepositoryDao();
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String msg() {
		return "<h1>API Rest Usuario CRUD</h1>";
	}
	/*
	 *  GET
	 */
	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> all (){
		List<Usuario> lista = repository.listar();
		return lista;
	}
	@GET
	@Path ("/listar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response usuario(@PathParam("id") int id) {
		repository.byId(id);
		return Response.status(Status.OK)
				.entity(repository.byId(id)).build();			
	}
	/*
	 * POST
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create (Usuario usuario){
		repository.create(usuario);
		return Response.status(Status.CREATED).build();
	}
	/*
	 * PUT
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Usuario usuario) {
		repository.update(usuario);
		return Response.status(Status.CREATED).build();
	}
	/*
	 * DELETE
	 */
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete (@PathParam ("id") int id) {
		repository.delete(id);
		return Response.status(Response.Status.ACCEPTED).build();
	}
}
