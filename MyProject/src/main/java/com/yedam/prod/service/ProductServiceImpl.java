package com.yedam.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.prod.domain.ProductVO;
import com.yedam.prod.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService{

	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);
	
	




	@Override
	public ProductVO getProd(ProductVO vo) {
		return mapper.infoProd();
	}

	@Override
	public boolean addProduct(ProductVO vo) {
		return mapper.addProd(vo) ==1;
	}

	@Override
	public boolean removeProduct(int prodCode) {
		return mapper.delProd(prodCode) == 1;
	}

	@Override
	public List<ProductVO> getProd() {
		return mapper.getProduct();
	}

	
}
