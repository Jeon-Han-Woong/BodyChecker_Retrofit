package org.ict.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.ict.domain.MemberVO;
import org.ict.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	@Transactional
	public MemberVO login(MemberVO vo) {
		try {
			vo.setPwd(encode(vo.getPwd()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return mapper.select(vo);
	}

	@Override
	@Transactional
	public void join(MemberVO vo) {
		try {
			vo.setPwd(encode(vo.getPwd()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		mapper.insert(vo);
	}

	@Override
	@Transactional
	public void modify(MemberVO vo) {
		try {
			vo.setPwd(encode(vo.getPwd()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		mapper.update(vo);
	}

	@Override
	public void remove(int mno) {
		mapper.delete(mno);
	}
	
	private String encode(String pwd) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(pwd.getBytes());
		String hex = String.format("%0128x", new BigInteger(1, md.digest()));
		
		return String.valueOf(hex);
	}

}