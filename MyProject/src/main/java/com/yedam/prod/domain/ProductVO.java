package com.yedam.prod.domain;

import lombok.Data;

@Data
public class ProductVO {

	private int productCode;
	private String productName;
	private String productExpl;
	private int productPrice;
	private int productSale;
	private int productGrade;
	private String attachFile;
}
