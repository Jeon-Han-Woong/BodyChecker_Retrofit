package org.ict.mapper;

import org.ict.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO select(MemberVO vo);
	
	public void insert(MemberVO vo);
	
	public void update(MemberVO vo);
	
	public void delete(int mno);
	
}
