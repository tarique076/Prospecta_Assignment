package com.prospecta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.entities.Products;

@Repository
public interface ProductDAO extends JpaRepository<Products, Integer>{

	public List<Products> findByCategory(String category);
	
}
