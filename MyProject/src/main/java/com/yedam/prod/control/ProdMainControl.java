package com.yedam.prod.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.domain.ProductVO;
import com.yedam.prod.service.ProductService;
import com.yedam.prod.service.ProductServiceImpl;

public class ProdMainControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodCode = req.getParameter("prodCode");
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.infoProd(Integer.parseInt(prodCode));
		req.setAttribute("ProductInfo", vo);
		
		return "prod/productMain.tiles";
	}

}
