package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long productId;
	public String productName;
	public int productPrice;
	public int productStock;
	public LocalDate productManufacturedDate;
	public LocalDate productExpiryDate;
	
	public Products() {
		super();
	}

	public Products(String productName, int productPrice, int productStock, LocalDate productManufacturedDate,
			LocalDate productExpiryDate) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productManufacturedDate = productManufacturedDate;
		this.productExpiryDate = productExpiryDate;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productStock=" + productStock + ", productManufacturedDate=" + productManufacturedDate
				+ ", productExpiryDate=" + productExpiryDate + "]";
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public LocalDate getProductManufacturedDate() {
		return productManufacturedDate;
	}

	public void setProductManufacturedDate(LocalDate productManufacturedDate) {
		this.productManufacturedDate = productManufacturedDate;
	}

	public LocalDate getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(LocalDate productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}
	
	
	
}