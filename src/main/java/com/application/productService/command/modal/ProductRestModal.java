package com.application.productService.command.modal;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRestModal {
	private String name;
	private BigDecimal price;
	private Integer quantity;

}
