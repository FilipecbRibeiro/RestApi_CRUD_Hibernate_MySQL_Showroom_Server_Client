package org.light.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.light.showroom.model.Product;
import org.light.showroom.services.ProductsService;

public class ProductsResource {
	
	private ProductsService productsService = new ProductsService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getListProductsByBrands( @PathParam("brandId") int brandId,@QueryParam("category") String category,
			@QueryParam("start") int start,@QueryParam("end") int end) {
		
		
		List<Product> productsEntityList;
		if(category!= null) {
			productsEntityList = productsService.getProductsByCategoryByBrands(brandId,category);
			
		}else {
			productsEntityList= productsService.getProductsByBrand(brandId);		
		}
		if(end> 0 ) {//this way only when are values will this be perform ! 
			productsEntityList = productsEntityList.subList(start, end);
		}
		
	return productsEntityList;	
	}
}



