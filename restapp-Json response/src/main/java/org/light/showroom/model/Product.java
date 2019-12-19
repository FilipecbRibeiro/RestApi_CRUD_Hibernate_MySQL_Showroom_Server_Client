package org.light.showroom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name="productsEntity")
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "productId")
	private int productId;
	
	@ManyToOne(targetEntity = Brand.class )
	//@Column(name="brandId")
	@JoinColumn(name="brandId")
	private Brand brandEntity;
	@Column(name="productName")
	private String productName;
	@Column(name="category")
	private String category;
	@Column(name="cost")
	private int cost;

	public Product() {
		
	}

	
	public Product(int productId, Brand brandEntity, String productName, String category, int cost) {
	
		this.productId = productId;
		this.brandEntity = brandEntity;
		this.productName = productName;
		this.category = category;
		this.cost = cost;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

	public Brand getBrandEntity() {
		return brandEntity;
	}


	public void setBrandEntity(Brand brandEntity) {
		this.brandEntity = brandEntity;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", brandEntity=" + brandEntity + ", productName=" + productName
				+ ", category=" + category + ", cost=" + cost + "]";
	}

	

}
