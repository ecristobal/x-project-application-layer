package com.x.project.application.layer.authentication.manager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/token")
public interface TokenGenerator {

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response getToken(final MultivaluedMap<String, String> params);

}
