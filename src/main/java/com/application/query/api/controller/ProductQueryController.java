package com.application.query.api.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.productService.command.modal.ProductRestModal;
import com.application.query.api.quries.GetProductsQuery;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

	private final QueryGateway queryGateway;
	
	public  ProductQueryController(QueryGateway queryGateway) {
		this.queryGateway = queryGateway;
	}
	
	@GetMapping
	public List<ProductRestModal> getAllProducts(){
		GetProductsQuery getProductsQuery = new GetProductsQuery();
		
		List<ProductRestModal> productRestModal = queryGateway.query(getProductsQuery,ResponseTypes.multipleInstancesOf(ProductRestModal.class)).join();
		return productRestModals;
		
	}
}
