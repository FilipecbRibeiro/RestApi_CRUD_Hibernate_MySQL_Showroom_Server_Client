package org.light.showroom.resources;



import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/")
public class DemoResource {

	
	@Context
	private UriInfo uriInfo ; 
	@Context
	private ServletContext servletContext;
	
	
		@GET
		@Produces(MediaType.TEXT_PLAIN)	
		public String usefulAnnotations(@HeaderParam("HeaderValue")String headerValue,@CookieParam("somevalue") String cookieParam) {
			return "Header Value is : " +headerValue + "Cookie Value" + cookieParam;
			//only visible on the web browser
		}
		
		@GET
		@Path("/demo")
		@Produces(MediaType.TEXT_PLAIN)
		public String contextDemo(@Context HttpHeaders header){
			
			return header.getRequestHeaders().keySet().toString();
			//because we are sending in the header of request the key = Headervalue value =conaca 
			//it will be on that keyset the key HeaderValue
			//	return "Absoute Path :" + uriInfo.getAbsolutePath().toString();
			
		}
		@GET
		@Path("/demo2")
		@Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
		public String contextDemo2(@HeaderParam("testValue")String header) throws Exception{
		
			if(header==null) {
			throw new NotFoundException();//WHENEVER THERE IS AN ERROR THIS WILL RETURN A JSON RESPONSE 
			//it will call the @Provider on NotFoundMapper inside of the org.light.showroom.exceptions
			}
			return "The Value of custom header value is : " + header;//IF THERE IS NO ERROR THIS WILL RETURN A TEXT_PLAIN RESPONSE!
		}
		
}
