package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.QuestionWrapper;
import com.model.Quizdto;
import com.model.ResponseFromUser;
import com.service.Quiz_service;

@RestController
@RequestMapping("quiz")
public class Quiz_controller {

	@Autowired
	Quiz_service quiz_service;
	
	@PostMapping("create")
	public ResponseEntity<String>createquiz(@RequestBody Quizdto quizdto)//@RequestParam String category, @RequestParam int numq, @RequestParam String title)
	{
		return quiz_service.createquiz(quizdto.getCategoryName(),quizdto.getNumQuestions(),quizdto.getTitle());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizquestion(@PathVariable Integer id){
		return quiz_service.getQuizquestion(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitquiz(@PathVariable Integer id,@RequestBody List<ResponseFromUser>response){
		return quiz_service.calculateResult(id,response);
	}
	
}
