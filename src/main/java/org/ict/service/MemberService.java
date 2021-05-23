package org.ict.service;

import org.ict.domain.MemberVO;

public interface MemberService {
	
	public MemberVO login(MemberVO vo);
	
	public void join(MemberVO vo);
	
	public void modify(MemberVO vo);
	
	public void remove(int mno);
	
}