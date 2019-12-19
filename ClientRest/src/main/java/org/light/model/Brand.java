package org.light.model;

import java.util.Arrays;

public class Brand {

	private int brandId;// the names should always match!
	private String brandName;
	private Link[] links;

	public Brand() {

	}

	public Brand(String brandName) {// to use post

		this.brandName = brandName;
	}

	public Brand(int brandId, String brandName) {// to use get
		this.brandId = brandId;
		this.brandName = brandName;
	}

	public Brand(int brandId, String brandName, Link[] links) {

		this.brandId = brandId;
		this.brandName = brandName;
		this.links = links;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public Link[] getLinks() {
		return links;
	}

	public void setLinks(Link[] links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", links=" + Arrays.toString(links) + "]";
	}
	
	public String displayBrands()
	{
		return "Brand [brandId=" + brandId + ", brandName=" + brandName  + "]";
	}


}
