package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Products;
import com.example.demo.repository.productRepo;

@Service
public class productService 
{
	@Autowired
	private productRepo pRepo;
	
	public String addProducts(Products pro)
	{
		Products addPro=new Products(pro.getProductName(),pro.getProductPrice(),pro.getProductStock(),pro.getProductManufacturedDate(),pro.getProductExpiryDate());
		pRepo.save(addPro);
		
		return "Entered Item is Added to System ";
	}
	
	public List<Products> showProducts()
	{
		return pRepo.findAll();
	}
	
	public String updateProductInfo(Long productId,Products pro)
	{
		Optional <Products> checkId=pRepo.findById(productId);
		
		if(checkId.isPresent())
		{
			Products updateInfo=checkId.get();
			
			updateInfo.setProductName(pro.getProductName());
			updateInfo.setProductPrice(pro.getProductPrice());
			updateInfo.setProductStock(pro.getProductStock());
			updateInfo.setProductManufacturedDate(pro.getProductManufacturedDate());
			updateInfo.setProductExpiryDate(pro.getProductExpiryDate());
			
			pRepo.save(updateInfo);
			return "Product Information Updation is Completed ";
		}
		
		else
		{
			return"Your Updation is Not Completed";
		}
	}
	
	public String deleteProduct(Long productId)
	{
		Optional<Products> checkId=pRepo.findById(productId);
		
		if(checkId.isPresent())
		{
			Products delId=checkId.get();
			
			pRepo.delete(delId);
			
			return "Entered "+productId+"'s Product is Permanently Deleted ";
		}
		else
		{
			return "Entered "+productId+" is Not Found Or Already Deleted";
		}
	}
	
	
}