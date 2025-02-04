package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.model.Products;
import com.example.demo.model.transactionOrder;
import com.example.demo.model.userRating;
import com.example.demo.service.orderService;
import com.example.demo.service.productService;

@RestController
@RequestMapping("admin")
public class adminController 
{

	@Autowired
	private productService apService;
	
	@Autowired
	private orderService aoService;
	
	@PostMapping("/addProduct")
	public String addProducts(@RequestBody Products pro)
	{
		return apService.addProducts(pro);
	}
	
	@GetMapping("/showProducts")
	public List<Products> showProducts()
	{
		return apService.showProducts();
	}
	
	
	@PutMapping("/updateProducts/{productId}")
	public String updateProductInfo(@PathVariable Long productId,@RequestBody Products pro)
	{
		return apService.updateProductInfo(productId, pro);
	}
	
	@DeleteMapping("/deleteProducts/{productId}")
	public String  deleteProduct(@PathVariable Long productId)
	{
		return apService.deleteProduct(productId);
	}
	
	@GetMapping("/showAllOrders")
	public List<Orders> showOrders()
	{
		return aoService.showOrders();
	}
	
	@GetMapping("/showAllRatings")
	public List<userRating> showRandR()
	{
		return aoService.showRandR();
	}
	
	@GetMapping("/showAllTransaction")
	public List<transactionOrder> showAllTransaction()
	{
		return aoService.showAllTransaction();
	}
}