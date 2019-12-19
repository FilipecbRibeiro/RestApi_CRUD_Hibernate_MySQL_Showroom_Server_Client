package org.light.showroom.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.light.showroom.model.ErrorPayload;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {

		ErrorPayload errorPayLoad= new ErrorPayload(500,"Internal server error");
		return Response.status(500).entity(errorPayLoad).build();
		
	}

}
