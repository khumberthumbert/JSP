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
		String page = req.getParameter("page");
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.getProd(Integer.parseInt(prodCode));
		req.setAttribute("ProductInfo", vo);


		if (vo.getAttachFile() != null) {
			String imgPath = req.getServletContext().getRealPath("images");
			Path file = Paths.get(imgPath + "/" + vo.getAttachFile());
			System.out.println(Files.probeContentType(file));
			String fileType = Files.probeContentType(file);
			req.setAttribute("fileType", fileType.substring(0, fileType.indexOf("/")));
		}
		
		return "prod/productMain.tiles";
	}

}
