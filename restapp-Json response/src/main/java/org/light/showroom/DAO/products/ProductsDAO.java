package org.light.showroom.DAO.products;

import java.util.List;

import org.light.showroom.model.Product;

public interface ProductsDAO {

	
	List<Product> getListBrandsByProducts(int brandId);
	List<Product> getListProductsCategoryFilterByBrand(int brandId, String category);
}
