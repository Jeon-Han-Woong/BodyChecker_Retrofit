package org.ict.controller;

import java.util.List;

import org.ict.domain.MealVO;
import org.ict.service.MealService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal/*")
public class RestMealController {
	final String SUCCESS = "SUCCESS";
	
	@Autowired
	private MealService service;
	
	@GetMapping(value="/getlist/{fdate}/{mno}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<MealVO>> getFoods(@PathVariable("fdate") String fdate, @PathVariable("mno") int mno) {
		ResponseEntity<List<MealVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<MealVO>>(service.getFoods(fdate, mno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<MealVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}//getFoods
	
	@PostMapping(value="/addFoods", consumes="application/json", produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addFoods(@RequestBody MealVO vo) {
		ResponseEntity<String> entity = null;
		
		try {
			service.addFoods(vo);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}//addFoods
	
	@DeleteMapping(value="/remove/{fdate}/{ftime}/{mno}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("fdate") String fdate, @PathVariable("ftime") String ftime, @PathVariable("mno") int mno) {
		ResponseEntity<String> entity = null;
		
		try {
			service.removeFoods(fdate, ftime, mno);
			entity = new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}//remove
	
}//class
