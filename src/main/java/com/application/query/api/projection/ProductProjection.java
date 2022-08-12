package com.application.query.api.projection;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import lombok.Builder;
import com.application.productService.command.data.Product;
import com.application.productService.command.data.ProductRepository;
import com.application.productService.command.modal.ProductRestModal;
import com.application.query.api.quries.GetProductsQuery;
import  com.application.productService.command.modal.*;

@Component
public class ProductProjection {
	
	private final ProductRepository productRepository;
	
	public ProductProjection (ProductRepository productRepository ) {
		this.productRepository = productRepository ;
	}
	

    @QueryHandler
    public List<ProductRestModal> handle(GetProductsQuery getProductsQuery) {
        List<Product> products =
                productRepository.findAll();

        List<ProductRestModal> productRestModels =
                products.stream()
                        .map(product -> ProductRestModal
                                .builder()
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName())
                                .build())
                        .collect(Collectors.toList());

        return productRestModels;
    }
	

}
