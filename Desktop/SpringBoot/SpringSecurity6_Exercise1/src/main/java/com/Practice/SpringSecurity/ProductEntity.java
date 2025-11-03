package com.Practice.SpringSecurity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductDetails")
public class ProductEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Or IDENTITY, SEQUENCE, TABLE
	private Long pId;
	private String pName;
	private double pPrice;
	private long pQuantity;
	
	
	public ProductEntity() {
	}
	public ProductEntity(Long pId, String pName, double price, long quantity) {
		this.pId = pId;
		this.pName = pName;
		this.pPrice = price;
		this.pQuantity = quantity;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getPrice() {
		return pPrice;
	}
	public void setPrice(double price) {
		this.pPrice = price;
	}
	public long getQuantity() {
		return pQuantity;
	}
	public void setQuantity(long quantity) {
		this.pQuantity = quantity;
	}
	
	@Override
	public String toString() {
		return "ProductEntity [pId=" + pId + ", pName=" + pName + ", price=" + pPrice + ", quantity=" + pQuantity + "]";
	}
	
}
