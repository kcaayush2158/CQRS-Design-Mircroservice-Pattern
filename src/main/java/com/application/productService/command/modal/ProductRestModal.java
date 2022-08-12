package com.application.productService.command.modal;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ProductRestModal {
	private String name;
	private BigDecimal price;
	private Integer quantity;

}
