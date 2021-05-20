package org.ict.domain;

import lombok.Data;

@Data
public class MemberVO {
	private int mno;
	private String mid;
	private String pwd;
	private String mname;
	private int gender;
	private int height;
	private int weight;
	private int bmi;
	private String birthday;
	private String regdate;
}
