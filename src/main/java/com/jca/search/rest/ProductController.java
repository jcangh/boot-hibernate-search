package com.jca.search.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jca.search.entity.ProductEntity;
import com.jca.search.service.ProductSearch;

@RestController
@RequestMapping("v1/products")
public class ProductController {
	
	@Autowired
	private ProductSearch search;
	
	@GetMapping(path = "/search/{text}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProductEntity>> search(@PathVariable("text") String text){
		return ResponseEntity.ok(search.search(text));
	}

}
