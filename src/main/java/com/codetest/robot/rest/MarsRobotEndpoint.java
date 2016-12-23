package com.codetest.robot.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.codetest.robot.model.Robot;

/**
 * Endpoint dos robôs de marte <br>
 * Todas as requisições de controle do robô passam por aqui
 * 
 * @author Ariel Rai Rodrigues (arielrairodrigues@gmail.com)
 *
 */
@Path("/mars")
public class MarsRobotEndpoint {

	@Inject 
	private Robot robot; // robô injetado por requisição!
	
	
	/**
	 * Recebe as requisições de movimentação do robô
	 * @param command - o comando que será executado pelo robô
	 * @return um {@link Response} com o estado atual do robô ou {@value Status#BAD_REQUEST} caso ocorra algo errado
	 */
	@POST
	@Path("/{command}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response control(@PathParam("command") String command) {
		try {
			return Response.ok(robot.control(command)).build();
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
}
