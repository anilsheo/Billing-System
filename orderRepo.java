package com.example.demo.repository;import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Orders;
import com.example.demo.model.userRating;

public interface orderRepo extends JpaRepository<Orders,Long> 
{

	List<userRating> save(userRating randr);

	

}
