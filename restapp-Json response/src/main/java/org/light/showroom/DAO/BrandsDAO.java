package org.light.showroom.DAO;

import java.util.List;

import org.light.showroom.model.Brand;

public interface BrandsDAO {
	
	public List<Brand> getListBrandsEntities();
	public void addBrand(Brand brand);
	public void updateBrand(Brand updateBrand);
	public void deleteBrand(int brandId);
	public Brand getBrand(int brandId);
	
	}

