package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Orders;
import com.example.demo.model.Products;
import com.example.demo.model.orderRequest;
import com.example.demo.model.transactionOrder;
import com.example.demo.model.userRating;
import com.example.demo.repository.orderRepo;
import com.example.demo.repository.productRepo;
import com.example.demo.repository.ratingRepo;
import com.example.demo.repository.transactionRepo;

@Service
public class orderService {

	@Autowired
	private orderRepo oRepo;
	
	@Autowired
	private productRepo pRepo;
	
	@Autowired
	private ratingRepo rRepo;
	
	
	@Autowired
	private transactionRepo tRepo;
	
	public String buyProducts(orderRequest oreq)
	{
		Optional <Products> checkId=pRepo.findById(oreq.productId);
		
		if(checkId.isPresent())
		{
			Products product=checkId.get();
			
			
			if(oreq.quantity >0 && product.getProductStock() >= oreq.quantity)
			{
				double totalPrice=oreq.quantity*product.getProductPrice();
				
				Orders order=new Orders();
				
				
				order.setUserId(oreq.userId);
				order.setProductId(oreq.productId);
				order.setProductName(oreq.productName);
				order.setQuantity(oreq.quantity);
				order.setTotalPrice(totalPrice);
				order.setOrderDate(LocalDateTime.now());
				
				oRepo.save(order);
				
				return "Your Order Is Confirmed  "+ " Your Total Bill Amount is :" +totalPrice;
			}
			else
			{
				return"Your Order is Not Confirmed ,Because " + product.getProductStock() + " Items Un Available ";
			}
		}
		else
		{
			return "Your Entered Details Are InVaild ";
		}
	}
	
	public List<Orders> showOrders()
	{
		return oRepo.findAll();
		
	}
	
	public String showMyOrder(Long userId)

	{
		Optional <Orders> checkId=oRepo.findById(userId);
		
		if(checkId.isPresent())
		{
			Orders getId=checkId.get();
			return "Yes, Your ID is Found.\nYour Order Details Are:\n" + getId;
		}
		else
		{
			return "Sorry your Id is Not Found";
		}
	}
	
	public List<userRating> ratingAndReview(userRating uR)
	{
		Optional<Orders> checkId=oRepo.findById(uR.userId);
		
		if(checkId.isPresent())
		{
			userRating randr =new userRating();
			
			randr.setUserId(uR.userId);
			randr.setProductId(uR.productId);
			randr.setProductName(uR.productName);
			randr.setRating(uR.rating);
			randr.setFeedBack(uR.feedBack);
			
			
			
			return oRepo.save(randr);
		}
		return null;
		
	}
	
	
	public List<userRating> showRandR()
	{
		return rRepo.findAll();
	}
	
	
	public String editReviews(userRating uR)
	{
		Optional<userRating> checkId=rRepo.findById(uR.userId);
		if(checkId.isPresent())
		{
			userRating updateRating=checkId.get();
			
			updateRating.setUserId(uR.getUserId());
			updateRating.setProductId(uR.getProductId());
			updateRating.setProductName(uR.getProductName());
			updateRating.setRating(uR.getRating());
			updateRating.setFeedBack(uR.getFeedBack());
			
			rRepo.save(updateRating);
			
			return "Your Review is Updated ";
		}
		else
		{
		 throw new IllegalArgumentException ("Your Id is Invalid ");
		}
	}
	
	public String paymentTransaction(transactionOrder to)
	{
		Optional<Orders> checkId=oRepo.findById(to.userId);
		
		if(checkId.isPresent())
		{
			transactionOrder tranOrder=new transactionOrder();
			
			tranOrder.setUserId(to.userId);
			tranOrder.setProductId(to.productId);
			tranOrder.setProductName(to.productName);
			tranOrder.setQuantity(to.quantity);
			tranOrder.setTotalPrice(to.totalPrice);
			tranOrder.setPayAmount(to.payAmount);
			
			
			tRepo.save(tranOrder);
			
			return "Done, Your Transaction is SuccessFull .\nYour Order Details Are:\n" + tranOrder;
				
		}
		else
		{
			return "Try Again , Your Order is Unsuccessfull , Check Your User Id";
		}
	}
	
	public List<transactionOrder> showAllTransaction()
	{
		return tRepo.findAll();
	}
}
