package com.prospecta.services;

import java.util.List;

import com.prospecta.entities.ProductDTO;
import com.prospecta.entities.Products;
import com.prospecta.exceptions.ProductException;

public interface CategoryServices {
		
	public List<ProductDTO> getByCategory(String category) throws ProductException;
	
	public Products saveProduct(Products product) throws ProductException;
}
