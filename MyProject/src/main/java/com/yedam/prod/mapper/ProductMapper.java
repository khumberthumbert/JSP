package com.yedam.prod.mapper;

import java.util.List;

import com.yedam.prod.domain.ProductVO;

public interface ProductMapper {
	public List<ProductVO> getProduct();
	public ProductVO infoProd(int productCode);
}
