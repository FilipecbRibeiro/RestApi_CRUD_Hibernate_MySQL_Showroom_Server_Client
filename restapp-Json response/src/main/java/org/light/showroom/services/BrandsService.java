package org.light.showroom.services;

import java.util.List;

import org.light.showroom.DAO.BrandsDAO;
import org.light.showroom.DAO.BrandsDAOImplementation;
import org.light.showroom.model.Brand;


public class BrandsService {

	private BrandsDAO DAO= new BrandsDAOImplementation();
	
	
	
	public List<Brand> getBrands() {
		//Calling Data Object Access method to add brand
		List<Brand> listofBrandsEntity = DAO.getListBrandsEntities();
		return listofBrandsEntity;
	}

	public void addBrand(Brand brand) {
		DAO.addBrand(brand);
		//Calling Data Object Access method to add brand
	}

	public void updateBrand(Brand updateBrand) {
		//Calling Data Object Access method to update brand
		System.out.println("enter on service");
		DAO.updateBrand(updateBrand);
	}

	public void delete(int brandId) {
		//Calling Data Object Access method to delete brand
		DAO.deleteBrand(brandId);
	}

	public Brand getBrand(int brandId) {
		
		return 	DAO.getBrand(brandId);
	}


}
