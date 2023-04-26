package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.service.EventService;
import com.yedam.member.service.EventServiceImpl;

public class RemoveEventControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eid = req.getParameter("eid");
		
		EventService service = new EventServiceImpl();
		
		String json = "";
		
		if(service.removeEvent(eid)) {
			json="{\"retCode\":\"Success\"}";
		} else {
			json = "{\"retCode\":\"Fail\"}";
		}
		
		return json + ".json";
		
	}

}
