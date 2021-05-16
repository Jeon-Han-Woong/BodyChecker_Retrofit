package org.ict.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ExerciseVO {
	
	private int eno;
	private String ename;
	private int ekcal;
	private int etime;
	private Date edate;
}
