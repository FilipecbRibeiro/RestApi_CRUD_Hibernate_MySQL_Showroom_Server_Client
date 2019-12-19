package org.light.showroom.services;

import java.util.List;

import org.light.showroom.DAO.products.ProductsDAO;
import org.light.showroom.DAO.products.ProductsDAOImplementation;
import org.light.showroom.model.Product;

public class ProductsService {

	private ProductsDAO DAOproducts= new ProductsDAOImplementation();
	public List<Product> getProductsByBrand(int brandId) {
	
		return DAOproducts.getListBrandsByProducts(brandId);
	}
	public List<Product>getProductsByCategoryByBrands(int brandId,String category)
	{
		return DAOproducts.getListProductsCategoryFilterByBrand(brandId,category);
	}

}
