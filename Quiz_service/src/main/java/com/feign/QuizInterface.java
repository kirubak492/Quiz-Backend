package com.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.QuestionWrapper;
import com.model.ResponseFromUser;

@FeignClient("QUESTION-SERVICE") // Question_service is is copy from eureka server name 
public interface QuizInterface {
	
	//for using interface we just declared method because it is implemented in question service part
	
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>>getQuestionForQuiz(
			@RequestParam String categoryName,@RequestParam Integer numQuestions);
	
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds);
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<ResponseFromUser> responses);
}
