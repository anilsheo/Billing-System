package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.userRating;

public interface ratingRepo extends JpaRepository <userRating,Long> 
{
	
}
