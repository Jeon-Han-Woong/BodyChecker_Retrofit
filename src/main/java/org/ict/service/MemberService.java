package org.ict.service;

import org.ict.domain.MemberVO;

public interface MemberService {
	
	public MemberVO getInfo(int mno);
	
	public Integer login(MemberVO vo);
	
	public void join(MemberVO vo);
	
	public void modify(MemberVO vo);
	
	public void remove(int mno);
	
	public int check(String mid);
	
	public int confirm(int mno, String pwd);
}
