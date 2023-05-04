package com.lottery.multiboard.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lottery.common.DataSource;
import com.lottery.multiboard.domain.MultiVO;
import com.lottery.multiboard.mapper.MultiMapper;


public class MultiServiceImpl implements MultiService {
	
	SqlSession session = DataSource.getInstance().openSession(true);
	MultiMapper mapper = session.getMapper(MultiMapper.class);
	
	@Override
	public List<MultiVO> listBoard(String mbGrade) {

		return mapper.listBoard(mbGrade);
	}
		
	@Override
	public int getCount(String mbGrade) {
		return mapper.getCount(mbGrade);
	}
}
