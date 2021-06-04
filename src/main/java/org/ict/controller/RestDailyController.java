package org.ict.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.ict.domain.DailyVO;
import org.ict.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/daily/*")
public class RestDailyController {
	final String SUCCESS = "SUCCESS";
	
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Autowired
	private DailyService service;
	
	@GetMapping(value="/get", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<DailyVO> getDaily(@RequestBody String date) {
		ResponseEntity<DailyVO> entity = null;
		
		try {
			entity = new ResponseEntity<DailyVO>(service.getDaily(date), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<DailyVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@PostMapping(value="/addDaily", consumes="application/json", produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addDaily(@RequestBody DailyVO vo) {
		ResponseEntity<String> entity = null;
		
		log.info(vo.getMno());
		
		try {
			service.addDaily(vo);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@GetMapping(value="/water/get/{ddate}/{mno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<Integer> getDailyWater(@PathVariable("ddate") String ddate, @PathVariable("mno") int mno) {
		ResponseEntity<Integer> entity = null;
		try {
			entity = new ResponseEntity<Integer>(service.getDailyWater(ddate, mno), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH}, value="/water/plus/{ddate}/{mno}", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Integer> plusWater(@PathVariable("ddate") String ddate, @PathVariable("mno") int mno) {
		ResponseEntity<Integer> entity = null;
		try {
			log.info(ddate);
			entity = new ResponseEntity<Integer>(service.plusWater(ddate, mno), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH}, value="/water/minus/{ddate}/{mno}", produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Integer> minusWater(@PathVariable("ddate") String ddate, @PathVariable("mno") int mno) {
		ResponseEntity<Integer> entity = null;
		try {
			entity = new ResponseEntity<Integer>(service.minusWater(ddate, mno), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping(value="/getwalk/{mno}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Integer> getWalk(@PathVariable("mno") int mno) {
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.getWalk(format.format(LocalDate.now()), mno), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//getWalk
	
	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH}, value="/addwalk/{mno}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> addWalk(@PathVariable("mno") int mno) {
		ResponseEntity<String> entity = null;
		try {
			service.addWalk(format.format(LocalDate.now()), mno);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//addWalk 

	
}//class
