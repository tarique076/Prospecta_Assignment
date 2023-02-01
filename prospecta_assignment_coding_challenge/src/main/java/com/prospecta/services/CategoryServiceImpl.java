package com.prospecta.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.entities.ProductDTO;
import com.prospecta.entities.Products;
import com.prospecta.exceptions.ProductException;
import com.prospecta.repository.ProductDAO;

@Service
public class CategoryServiceImpl implements CategoryServices{

	@Autowired
	private ProductDAO pDao;
	
	@Override
	public List<ProductDTO> getByCategory(String category) throws ProductException {
		// TODO Auto-generated method stub
		List<Products> products = pDao.findByCategory(category);
		
		if(products.size()==0) {
			throw new ProductException("No details found for category " + category);
		}
		
		List<ProductDTO> response = new ArrayList<>();
		
		for(Products p : products) {
			ProductDTO pd = new ProductDTO(p.getTitle(), p.getDescription());
			response.add(pd);
		}
		
		return response;
	}

	@Override
	public Products saveProduct(Products product) throws ProductException {
		// TODO Auto-generated method stub
		
		return pDao.save(product);
	}

}
