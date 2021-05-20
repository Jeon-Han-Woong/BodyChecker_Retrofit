package org.ict.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class MealVO {
	private int fno;
	private String fname;
	private int fkcal;
	private String ftime;
	private Date fdate;
	private int mno;
}