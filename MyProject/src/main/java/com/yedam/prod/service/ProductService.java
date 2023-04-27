package com.yedam.prod.service;

import java.util.List;

import com.yedam.prod.domain.ProductVO;

public interface ProductService {

	public boolean addProduct(ProductVO vo);
	public boolean removeProduct(int prodCode);
	public List<ProductVO> getProd();
	public ProductVO getProd(ProductVO vo);
}
