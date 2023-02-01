package com.prospecta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.entities.ProductDTO;
import com.prospecta.entities.Products;
import com.prospecta.exceptions.ProductException;
import com.prospecta.services.CategoryServiceImpl;

@RestController
@RequestMapping("prospecta/")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl cService;

	@GetMapping("{category}")
	public ResponseEntity<List<ProductDTO>> getByCategory(@PathVariable("category") String category) throws ProductException{
		
		List<ProductDTO> products = cService.getByCategory(category);
		
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}
	
	@PostMapping("product")
	public ResponseEntity<Products> saveProduct(@RequestBody Products product) throws ProductException{
		
		Products savedProduct = cService.saveProduct(product);
		
		return new ResponseEntity<Products>(savedProduct, HttpStatus.ACCEPTED);
	}
}
