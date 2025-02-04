package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long orderId;
	public Long userId;
	public Long productId;
	public String productName;
	public Long quantity;
	public double totalPrice;
	public LocalDateTime orderDate;
	public Orders(Long userId, Long productId,String productName, Long quantity, double totalPrice, LocalDateTime orderDate) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.productName=productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId + ", productName="
				+ productName + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate
				+ "]";
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	
	
	
}