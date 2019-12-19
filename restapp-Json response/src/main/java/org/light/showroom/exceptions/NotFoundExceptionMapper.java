package org.light.showroom.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.light.showroom.model.ErrorPayload;


@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException>{

	@Override
	public Response toResponse(NotFoundException exception) {
		ErrorPayload errorPayload  = new ErrorPayload(404, "Element not found");
		
		return Response.status(Status.NOT_FOUND).entity(errorPayload).build();
	}



}
