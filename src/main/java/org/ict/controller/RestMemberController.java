package org.ict.controller;

import org.ict.domain.MemberVO;
import org.ict.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/*")
public class RestMemberController {
	final String SUCCESS = "SUCCESS";

	@Autowired
	private MemberService service;
	
	@PostMapping(value="/login", consumes="application/json", produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<MemberVO> login(@RequestBody MemberVO vo) {
		ResponseEntity<MemberVO> entity = null;
		
		try {
			entity = new ResponseEntity<MemberVO>(service.login(vo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<MemberVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@PostMapping(value="/join", consumes="application/json", produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> join(@RequestBody MemberVO vo) {
		ResponseEntity<String> entity = null;
		
		try {
			service.join(vo);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH}, value="/modify", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modify(@RequestBody MemberVO vo) {
		ResponseEntity<String> entity = null;
		
		try {
			service.modify(vo);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@DeleteMapping(value="/remove")
	public ResponseEntity<String> remove(@RequestBody int mno) {
		ResponseEntity<String> entity = null;
		
		try {
			service.remove(mno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}//remove
	
}//class