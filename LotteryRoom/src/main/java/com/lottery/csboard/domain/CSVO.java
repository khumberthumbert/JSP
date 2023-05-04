package com.lottery.csboard.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CSVO {
	
	private String userName;
	private int cbId;
	private int userNo;
	private String cbGrade;
	private String cbTitle;
	private String cbSubject;
	private Date cbDate;
	private String cbAttach;
	private int cbHit;
}
