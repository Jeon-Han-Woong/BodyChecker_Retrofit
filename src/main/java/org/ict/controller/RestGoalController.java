package org.ict.controller;

import java.util.List;

import org.ict.domain.GoalVO;
import org.ict.service.GoalService;
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
@RequestMapping("/goal")
public class RestGoalController {
	
	@Autowired
	private GoalService service;
	
	// 진행중인 목표 REST
	
	@GetMapping(value="/doing/{fin_date}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<GoalVO>> getGoalList(@PathVariable("fin_date") String fin_date){
		ResponseEntity<List<GoalVO>> entity = null;
		
		try {
			entity = new ResponseEntity<List<GoalVO>>(service.getDoing(fin_date), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<GoalVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@GetMapping(value="/newgno", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Integer> getNewGno(){
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<Integer>(service.getNewGno(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@PostMapping(value="/new", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> regDoing(@RequestBody GoalVO goal){
		ResponseEntity<String> entity = null;
		
		try {
			service.regDoing(goal);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	@PutMapping(value="/modify/{gno}", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> regDoing(@RequestBody GoalVO goal, @PathVariable("gno") int gno){
		ResponseEntity<String> entity = null;
		
		try {
			service.modDoing(goal);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	@DeleteMapping(value="/remove/{gno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> regGoal(@PathVariable("gno") int gno){
		ResponseEntity<String> entity = null;
		
		try {
			service.remGoal(gno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
		
	}
	
	// 종료된 목표 REST
	
	@GetMapping(value="/finish/{fin_date}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<GoalVO>> getFinList(@PathVariable("fin_date") String fin_date){
		ResponseEntity<List<GoalVO>> entity = null;
		try {
			entity = new ResponseEntity<List<GoalVO>>(service.getFinish(fin_date), HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<List<GoalVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@PutMapping(value="/finish/success/{gno}", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> selectSuccess(@PathVariable("gno") int gno, @RequestBody GoalVO goal){
		ResponseEntity<String> entity = null;
		try {
			service.selectSuccess(goal);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
//	@PutMapping(value="/finish/fail/{gno}", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
//	public ResponseEntity<String> selectFail(@PathVariable("gno") int gno){
//		ResponseEntity<String> entity = null;
//		try {
//			service.selectFail(gno);
//			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//		} catch(Exception e) {
//			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//		return entity;
//	}


}
