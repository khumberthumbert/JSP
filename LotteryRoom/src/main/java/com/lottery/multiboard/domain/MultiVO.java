package com.lottery.multiboard.domain;



import java.util.Date;

import lombok.Data;

@Data
public class MultiVO {
//  Lottery_User
//	USER_NO    NOT NULL NUMBER        
//	USER_NAME  NOT NULL VARCHAR2(15)  
//	USER_ID    NOT NULL VARCHAR2(30)  
//	USER_PW    NOT NULL VARCHAR2(30)  
//	ADDRESS    NOT NULL VARCHAR2(100) 
//	PHONE      NOT NULL VARCHAR2(13)  
//	MILEAGE    NOT NULL NUMBER        
//	USER_GRADE NOT NULL VARCHAR2(5)   
//	USER_DATE           DATE    
	
	
//  MB_Board
//	MB_ID      NOT NULL NUMBER         
//	USER_NO    NOT NULL NUMBER         
//	MB_GRADE   NOT NULL VARCHAR2(5)    
//	MB_TITLE   NOT NULL VARCHAR2(100)  
//	MB_SUBJECT NOT NULL VARCHAR2(1000) 
//	MB_DATE             DATE           
//	MB_ATTACH           VARCHAR2(100)  
//  MB_HIT     NOT NULL NUMBER  
	private String userName;
	private String userId;
	private String userGrade;
	private int mbId;
	private int userNo;
	private String mbGrade;
	private String mbTitle;
	private String mbSubject;
	private Date mbDate;
	private String mbAttach;
	private int mbHit;
}
