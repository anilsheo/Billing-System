package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.transactionOrder;

public interface transactionRepo extends JpaRepository <transactionOrder,Long> 
{

}
