package com.lottery.csboard.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lottery.common.DataSource;
import com.lottery.csboard.domain.CSVO;
import com.lottery.csboard.mapper.CSBoardMapper;

public class CSBoardServiceImpl implements CSBoardService {
	
	private SqlSession session = DataSource.getInstance().openSession(true);
	private CSBoardMapper mapper = session.getMapper(CSBoardMapper.class);
	
	@Override
	public List<CSVO> ListSc(String cbGrade) {
		return mapper.csList(cbGrade);
	}
	
	@Override
	public CSVO getBoard(int cbId) {
		return mapper.searchBoard(cbId);
	}

	@Override
	public boolean addBoard(CSVO vo) {
		return mapper.insertBoard(vo) == 1;
	}

	@Override
	public boolean removeBoard(int cbId) {
		return mapper.deleteBoard(cbId) == 1;
	}
	
	
	
	
	
}