package com.yedam.member.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	//멤버정보를 담아놓는.
	private String email;
	private String password;
	private String name;
	private String phone;
	private String address;
	private String auth;
	private Date createDate;
}