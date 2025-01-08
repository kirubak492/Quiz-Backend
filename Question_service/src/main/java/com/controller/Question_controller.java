package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Question;
import com.model.QuestionWrapper;
import com.model.ResponseFromUser;
import com.service.Question_service;

@RestController
@RequestMapping("question")
public class Question_controller {
	
	@Autowired
	private Question_service questionservice;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllquestions() {
		return questionservice.getAllquestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getquestionsbycategory(@PathVariable String category){
		return questionservice.getquestionbycategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionservice.addquestion(question);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>>getQuestionForQuiz(
			@RequestParam String categoryName,@RequestParam Integer numQuestions){
		
		return questionservice.getQuestionForQuiz(categoryName,numQuestions);
	}
	
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds)
	{
		return questionservice.getQuestionFromId(questionIds);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<ResponseFromUser> responses){
		return questionservice.getScore(responses);
	}
}
