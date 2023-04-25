package com.yedam.notice.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class ModifyReplyControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 파라미터(댓글 번호, 변경된 댓글내용)
		// update.
		
		// search.
		ReplyService service = new ReplyServiceImpl();
		ReplyVO vo = new ReplyVO();
		
		String id = req.getParameter("rid");
		String replyId = req.getParameter("reply_id");
		String reply = req.getParameter("reply");
		
		vo.setReplyWriter(id);
		vo.setReplyId(Integer.parseInt(replyId));
		vo.setReply(reply);
		
		String json = "";
		Map<String, Object> map = new HashMap<>();
		
		boolean result = service.updateReply(vo);
		if(result) {
			//search
			vo = service.searchReply(vo.getReplyId());
			System.out.println(vo);
			map.put("retCode", "Success");
			map.put("data", vo);
			
		} else {
			System.out.println(result);
			map.put("retCode", "Fail");
		}
		
		Gson gson = new GsonBuilder().create(); // gson 객체.
		json = gson.toJson(map);
		
		return json + ".json";
	}

}
