package org.light.showroom.DAO.products;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.light.showroom.model.Brand;
import org.light.showroom.model.Product;

public class ProductsDAOImplementation implements ProductsDAO {

	
	private SessionFactory factory = new Configuration()
									  .configure("hibernate.cfg.xml")
									  .addAnnotatedClass(Product.class)
									  .addAnnotatedClass(Brand.class)
									  .buildSessionFactory();
	@SuppressWarnings("unchecked")
	@Override
		public List<Product> getListBrandsByProducts(int brandId) {
			
		Session session  = factory.getCurrentSession();
		session.beginTransaction();
		List<Product> listofProductsEntityDB;
		String HQL = "from productsEntity where brandId='"+brandId+"'";
		listofProductsEntityDB= session.createQuery(HQL).getResultList();
		session.getTransaction().commit();
		session.close();
		return listofProductsEntityDB;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getListProductsCategoryFilterByBrand(int brandId, String category) {
		List<Product> listOfProductsCategoryByBrand;
		String HQL= "from productsEntity where brandId='"+brandId+"' AND category='"+category+"'";
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		listOfProductsCategoryByBrand=session.createQuery(HQL).getResultList();
		session.getTransaction().commit();
		session.close();
		return listOfProductsCategoryByBrand;
		
		
	}

}
