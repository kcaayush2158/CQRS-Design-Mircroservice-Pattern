package com.application.productService.command.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.productService.command.commands.CreateProductCommand;
import com.application.productService.command.modal.ProductRestModal;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
	private final CommandGateway commandGateway;
	
	public ProductCommandController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}
	
	
	@PostMapping
	public String addProduct(@RequestBody ProductRestModal productRestModal) {
		
		  CreateProductCommand createProductCommand =
	                CreateProductCommand.builder()
					 .productId(UUID.randomUUID().toString())
                     .name(productRestModal.getName())
                     .price(productRestModal.getPrice())
                     .quantity(productRestModal.getQuantity())
                     .build();			
		
		String result = commandGateway.sendAndWait(createProductCommand);
		return result;
	}
	
	
}
