package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Products;
import com.example.demo.model.orderRequest;
import com.example.demo.model.transactionOrder;
import com.example.demo.model.userRating;
import com.example.demo.service.orderService;
import com.example.demo.service.productService;

@RestController
@RequestMapping("user")
public class userController 
{
	@Autowired 
	private productService upService;
	
	@Autowired
	private orderService uoService;
	
	@GetMapping("/showProducts")
	public List<Products> showProducts()
	{
		return upService.showProducts();
	}
	
	@PostMapping("/order")
	public ResponseEntity <String> buyProducts(@RequestBody orderRequest oR)
	{
		String response=uoService.buyProducts(oR);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/showMyOrder/{userId}")
	public String showMyOrder(@PathVariable Long userId)
	{
		return uoService.showMyOrder(userId);
	}
	
	@PostMapping("/ratingAndReview/{userId}")
	public List<userRating>ratingAndReview(@PathVariable Long userId,@RequestBody userRating uR)
	{
		return uoService.ratingAndReview(uR);
	}
	
	@GetMapping("/showAllRatings")
	public List<userRating> showRandR()
	{
		return uoService.showRandR();
	}

	@PutMapping("/updateMyReview/{userId}")
	public String editReviews(@PathVariable Long userId,@RequestBody userRating uR)
	{
		return uoService.editReviews(uR);
	}
	
	@PostMapping("/transaction/{userId}")
	public String paymentTransaction(@PathVariable Long userId, @RequestBody transactionOrder to)
	{
		return uoService.paymentTransaction(to);
	}
}