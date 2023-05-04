package com.lottery.multiboard.service;

import java.util.List;

import com.lottery.multiboard.domain.MultiVO;

public interface MultiService {
	public List<MultiVO> listBoard(String mbGrade); // 공지사항 전체 리스트 조회
	public int getCount(String mbGrade); // 게시물 갯수 확인
}
