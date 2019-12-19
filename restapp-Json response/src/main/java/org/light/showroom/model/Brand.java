package org.light.showroom.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;





@Entity(name = "brandentity")
@Table(name="brands")
public class Brand {
		
		@Id
		@Column(name ="brandId" )
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int brandId; 
		@Column(name ="brandName" )
		private String brandName;
		@Transient
		private List<Link> links;
		//because this links is not part of our table the @Annotations above won't be used on it
		//but we still need to tell hibernate to not map this particular property!
		public Brand() {
		
		}
		public Brand(int brandId, String brandName) {
		
			this.brandId = brandId;
			this.brandName = brandName;
		}
		
		
		public List<Link> getLinks() {
			return links;
		}
		public void setLinks(List<Link> links) {
			this.links = links;
		}
		public Brand(int brandId, String brandName, List<Link> links) {
			super();
			this.brandId = brandId;
			this.brandName = brandName;
			this.links = links;
		}
		public int getBrandId() {
			return brandId;
		} 
		public void setBrandId(int brandId) {
			this.brandId = brandId;
		}
		public String getBrandName() {
			return brandName;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		@Override
		public String toString() {
			return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", links=" + links + "]";
		}
		
		
		
		
}
