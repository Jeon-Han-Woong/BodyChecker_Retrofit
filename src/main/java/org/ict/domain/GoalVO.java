package org.ict.domain;

import lombok.Data;

@Data
public class GoalVO {
	private int gno;
	private String gtitle;
	private String gcontent;
	private String set_date;
	private String fin_date;
	private int gsts;
	private int mno;
}
