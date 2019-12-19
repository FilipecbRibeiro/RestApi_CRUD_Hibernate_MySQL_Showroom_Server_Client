package org.light.showroom.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.light.showroom.model.Brand;
import org.light.showroom.model.Link;
import org.light.showroom.services.BrandsService;


@Path("/showroom/brands")

public class BrandsResource {

	private BrandsService brandsService = new BrandsService();// responsive for the service layer!!!
	// which will contain an object of the type BrandsDAO;

	
	 
	// If we use TEXT_PLAIN jax-rs wont know how to convert listOfBrands!!!
	// we should use Application_XML but when we produce a XML Response jersey
	// jax-rs definitely will
	// require aditional info based on the list type in this case BrandEntity and we
	// must
	// specify on that BrandEntity with @XmlRootElement and jax -rs will be able to
	// convert the list into XML
	
	
	@GET // get all brands
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> getBrands() {
		List<Brand> listofBrands = brandsService.getBrands();

		return listofBrands;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{brandId}")//get brand based on brandID
	public Brand getBrand(@PathParam("brandId")int brandId, @Context UriInfo uri) {
	
		Link self = new Link(uri.getAbsolutePath().toString(), "self");
	//	URI location = uri.getAbsolutePathBuilder().path("products").build();
	//	Link products = new Link(location.toString(), "products");
		String productsUri = uri.getBaseUriBuilder().path(BrandsResource.class)
													.path(BrandsResource.class,"productsDelegation")
													.resolveTemplate("brandId", brandId).toString();		
		Brand brand = brandsService.getBrand(brandId);
		Link products = new Link(productsUri,"products");
		//Injecting the link information
		List<Link> links = new ArrayList<Link>();
		links.add(self);
		links.add(products);
		brand.setLinks(links);
		return brand; 
	}
	
	
	//Delegation
	@Path("/{brandId}/products")//get Products by BrandID!
	public ProductsResource productsDelegation() {
		return new ProductsResource();
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	// because it's void it won't produce anything so we will use the Annotation
	// @Consume!
	@Produces(MediaType.APPLICATION_JSON)//Add new Brand
	public Response postBrands(Brand brand, @Context UriInfo info ) {
		brandsService.addBrand(brand);	
		URI location = info.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build();
		return Response.created(location).entity(brand).build();
	
	}//	String URL =info.getAbsolutePath().toString()+"/"+brand.getBrandId();
	//	URI location = URI.create(URL);//this will generate absolute path showroom/brands 

	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void putBrands(@PathParam("brandId") int brandId, Brand updateBrand) {//update brand based on Id

		// IN ORDER TO ADD AN ADDITIONAL LAYER OF CONSISTENCY WE SHOULD UPDATE BRAND
		// OBJECT ID
		updateBrand.setBrandId(brandId);
		brandsService.updateBrand(updateBrand);
		//return Response.status(Status.NO_CONTENT).entity(updateBrand).build();
	}

	@DELETE
	@Path("/{brandId}")

	public void deleteBrands(@PathParam("brandId") int brandId) {

		brandsService.delete(brandId);
	}

}
//If we add simply like this the post method wont work complaining about "method not allowed" because its a post method 
// and we cant reach it by URI so what is the solution ?
// NOTE : browsers are limited so by default they are limited to the get
// request!
// WE CAN EITHER USE EXTENSIONS ON THE WEB BROWSER OR PROGRAMS
