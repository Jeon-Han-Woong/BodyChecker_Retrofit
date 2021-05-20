package org.ict.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal/*")
public class RestMealController {
	final String SUCCESS = "SUCCESS";
	
	@Autowired
	private MealService service;
	
	@GetMapping(value="/getList", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<MealVO>> getFoods(@PathVariable("date") Date date) {
		ResponseEntity<List<MealVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<MealVO>>(service.getFoods(date), HttpStatus.OK);
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
	
	@DeleteMapping(value="/remove", consumes="application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@RequestBody String ftime) {
		ResponseEntity<String> entity = null;
		
		try {
			service.removeFoods(ftime);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}//remove
	
	@PostMapping(value="/modifyFoods/{vo}/{ftime}", consumes="application/json", produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modifyFoods(@PathVariable("vo") MealVO vo, @PathVariable("ftime") String ftime) {
		ResponseEntity<String> entity=null;
		
		try {
			service.modifyFoods(vo, ftime);
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;			
	}//prodModify
	
}//class
