package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Products;

public interface productRepo extends JpaRepository<Products , Long >
{

}