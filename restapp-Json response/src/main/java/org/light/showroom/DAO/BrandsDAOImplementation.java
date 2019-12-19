package org.light.showroom.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.light.showroom.model.Brand;

public class BrandsDAOImplementation implements BrandsDAO{
	
	SessionFactory factory  = new Configuration()
							      .configure("hibernate.cfg.xml")
							      .addAnnotatedClass(Brand.class)
							      .buildSessionFactory();
	

	@Override
	public List<Brand> getListBrandsEntities() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Brand> listofBrands = (List<Brand>)session.createQuery("from brandentity").getResultList();//
		//"from brandentity " ----> brandEntity because on org.light.showroom.hibernate.entities @Entity(name="brandentity")
		session.getTransaction().commit();
		session.close();
		return listofBrands;
	}

	@Override
	public void addBrand(Brand brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public void updateBrand(Brand updateBrand) {
		Session session= factory.getCurrentSession();
		session.beginTransaction();
		Brand brandToUpdate = session.get(Brand.class, updateBrand.getBrandId());//old version of brand to update
		brandToUpdate.setBrandName(updateBrand.getBrandName());
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Brand brandtoDelete = session.get(Brand.class, brandId);
		session.delete(brandtoDelete);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public Brand getBrand(int brandId) {
		Session session= factory.getCurrentSession();
		session.beginTransaction();
	
		return session.get(Brand.class, brandId);
	}

}
