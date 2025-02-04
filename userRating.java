package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class userRating 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long reviewsId;
	public Long userId;
	public Long productId;
	public String productName;
	public Long rating;
	public String feedBack;
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
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	public Long getReviewsId() {
		return reviewsId;
	}
	public void setReviewsId(Long reviewsId) {
		this.reviewsId = reviewsId;
	}
	
	
	

}
