package com.yedam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @AllArgsConstructor 생성자도 만들어줌
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String jobId;
	
}
