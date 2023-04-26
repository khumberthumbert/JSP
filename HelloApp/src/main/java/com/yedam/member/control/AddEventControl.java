package com.yedam.member.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.domain.EventVO;
import com.yedam.member.service.EventService;
import com.yedam.member.service.EventServiceImpl;

public class AddEventControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("title");
		String startDate= req.getParameter("start_date");
		String endDate= req.getParameter("start_date");
		
		EventVO vo = new EventVO();
		vo.setTitle(endDate);
		vo.setStartDate(startDate);
		vo.setEndDate(endDate);
		
		EventService service = new EventServiceImpl();
		boolean result = service.addEvent(vo);
		
		String json="";
		
		Map<String, Object> map = new HashMap<>();
		if(result) {
			map.put("retCode", "Success");
		} else {
			map.put("retCode", "Fail");
		}
		Gson gson = new GsonBuilder().create();
		json = gson.toJson(map);
		return json + ".json";
	}

}
