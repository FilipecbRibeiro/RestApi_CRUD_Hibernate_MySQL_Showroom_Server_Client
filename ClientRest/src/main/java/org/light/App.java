package org.light;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.light.model.Brand;

 
@Path("nice")
//@Singleton
public class App {
   
	static Client client= ClientBuilder.newClient();
	static WebTarget baseBrandUrl= client.target("http://localhost:8080/restapp/showroom/brands");  
	static WebTarget brandURL = baseBrandUrl.path("{brandId}");
 
	public static void main(String[] args) {

//////////////////////////////////////////////////////////////////////////////////////////
		////GET ALL
	Response response = baseBrandUrl.request(MediaType.APPLICATION_JSON).get();
	Brand[] readEntity = response.readEntity(Brand[].class);
	for( Brand run : readEntity) {
		System.out.println("---->" + run.displayBrands());
	}
	///////////////    GET SPECIFIC///////////////////////////////
//	
//	Response specifiBrand = brandURL.resolveTemplate("brandId","2")
//			  .request(MediaType.APPLICATION_JSON).get();
//	 Brand specific = specifiBrand.readEntity(Brand.class);
//System.out.println(specific.displayBrands());
		Brand specificBrand = brandURL.resolveTemplate("brandId","2")
									  .request(MediaType.APPLICATION_JSON).get(Brand.class);
		System.out.println(specificBrand);
		///////////////////////////POSTING///////////////////////////////////
//		
//	Response response= baseBrandUrl.request(MediaType.APPLICATION_JSON)
//									.post(Entity.json(new Brand("VAMOSQUEARDE"))) ;
//	System.out.println(response.readEntity(String.class));
//	POST METHOD
		 Response post = baseBrandUrl.request(MediaType.APPLICATION_JSON).post(Entity.json(new Brand("kawasaki")));
			System.out.println(post.readEntity(Brand.class).displayBrands());
			////////////////////////////// PUT //////////////////////////////////////
			Response putResponse = brandURL.resolveTemplate("brandId", "4").request(MediaType.APPLICATION_JSON)
																		.put(Entity.json(new Brand("Yamaha")));
			System.out.println(putResponse.readEntity(Brand.class).displayBrands());
			
//////////////////////////////Delete//////////////////////////////////////
			Response deleteResponse = brandURL.resolveTemplate("brandId", "15").request()
					.delete();



Response response2 = baseBrandUrl.request(MediaType.APPLICATION_JSON).get();
Brand[] readEntity2 = response2.readEntity(Brand[].class);
for( Brand run : readEntity2) {
	System.out.println("---->" + run.displayBrands());
}
	}	
}







//@GET
//@Produces(MediaType.TEXT_PLAIN)
//
//public String demo() {
//	Client client= ClientBuilder.newClient();  
//	String response = client.target("http://localhost:8080/restapp/showroom/brands/2").request(MediaType.APPLICATION_JSON).get(String.class);
//	return response;
//}
///////////////////////////////////////////////////////////////////////////////
//@GET
//Produces(MediaType.Application_JSON);
//public String demo() {
////Building URL
//Client client= ClientBuilder.newClient();
//WebTarget baseBrandUrl= client.target("http://localhost:8080/restapp/showroom/brands");  
//WebTarget brandURL = baseBrandUrl.path("{brandId}");
////Requesting 
//Builder request = brandURL
//.resolveTemplate("brandId", "2")
//.request(MediaType.APPLICATION_JSON);
//.get(String.class);
//return response;
//}  
