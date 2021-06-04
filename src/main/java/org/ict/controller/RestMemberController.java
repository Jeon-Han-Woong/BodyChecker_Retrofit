package org.ict.controller;

import org.ict.domain.MemberVO;
import org.ict.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/member/*")
public class RestMemberController {
	final String SUCCESS = "SUCCESS";

	@Autowired
	private MemberService service;
	
	@GetMapping(value="/getinfo/{mno}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MemberVO> getInfo(@PathVariable("mno") int mno) {
		ResponseEntity<MemberVO> entity = null;
		
		try {
			entity = new ResponseEntity<MemberVO>(service.getInfo(mno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<MemberVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> login(@RequestBody MemberVO vo) {
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.login(vo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@PostMapping(value="/join", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
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
	
	@DeleteMapping(value="/remove/{mno}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("mno") int mno) {
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
	
	@PostMapping(value="/check/{mid}", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> check(@PathVariable("mid") String mid) {
		ResponseEntity<String> entity  = null;
		
		try {
			entity = new ResponseEntity<String>(String.valueOf(service.check(mid)), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}//check
	
	@PostMapping(value="/confirm/{mno}/{pwd}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> confirm(@PathVariable("mno") int mno, @PathVariable("pwd") String pwd) {
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.confirm(mno, pwd), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}//class