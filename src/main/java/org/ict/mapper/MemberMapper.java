package org.ict.mapper;

import org.apache.ibatis.annotations.Param;
import org.ict.domain.MemberVO;

public interface MemberMapper {
	
	public MemberVO select(int mno);
	
	public Integer login(@Param("mid") String mid, @Param("pwd") String pwd);
	
	public void insert(MemberVO vo);
	
	public void update(MemberVO vo);
	
	public void delete(int mno);
	
	public int check(String mid);
}
