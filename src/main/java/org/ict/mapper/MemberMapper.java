package org.ict.mapper;

import org.apache.ibatis.annotations.Param;
import org.ict.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO select(int mno);
	
	public Integer login(MemberVO vo);
	
	public void insert(MemberVO vo);
	
	public void update(MemberVO vo);
	
	public void delete(int mno);
	
	public int check(String mid);
	
	public int confirm(@Param("mno") int mno, @Param("pwd") String pwd);
}
