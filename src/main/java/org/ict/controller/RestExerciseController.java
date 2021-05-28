package org.ict.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ict.domain.ExerciseVO;
import org.ict.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exer")
public class RestExerciseController {
	
	@Autowired ExerciseService service;
	
	@GetMapping(value="/{edate}/{mno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ExerciseVO>> getExerList(@PathVariable("edate") String edate, @PathVariable("mno") int mno){
		 
		ResponseEntity<List<ExerciseVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<ExerciseVO>>(service.getAll(edate, mno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ExerciseVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping(value="/kcal/{edate}/{mno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Integer> getSumKcal(@PathVariable("edate") String edate, @PathVariable("mno") int mno){
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.getSumKcal(edate, mno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@GetMapping(value="/neweno", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Integer> getNewEno(){
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.getEno(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@PostMapping(value="/new", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> regExer(@RequestBody ExerciseVO exer) {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.regExer(exer);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	@PutMapping(value="/modify/{eno}", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modiExer(@RequestBody ExerciseVO exer, @PathVariable("eno") int eno){
		ResponseEntity<String> entity = null;
		
		try {
			service.modiExer(exer);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@DeleteMapping(value="/remove/{eno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> removeExer(@PathVariable("eno") int eno) {
		
		ResponseEntity<String> entity = null;
		
		try {
			service.removeExer(eno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}

}
