package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dao.QuizDao;
import com.feign.QuizInterface;

import com.model.QuestionWrapper;
import com.model.Quiz;
import com.model.ResponseFromUser;

@Service
public class Quiz_service {

	@Autowired
	QuizDao quizdao;

	//@Autowired
	//QuestionDao questiondao;
	
	@Autowired
	QuizInterface quizinterface;
	
	public ResponseEntity<String> createquiz(String category, int numq, String title) {
		
	    List<Integer> questions=  quizinterface.getQuestionForQuiz(category, numq).getBody();// call the other service using Rest Template
		
	    Quiz quiz=new Quiz();
	    quiz.setQuestionsIds(questions);
	    quiz.setTitle(title);
	    quizdao.save(quiz);
	    
	    
	    return new ResponseEntity<>("Success",HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizquestion(Integer id) {
		
    	  Quiz quiz = quizdao.findById(id).get();
    	  List<Integer> questionids=quiz.getQuestionsIds();
    	 ResponseEntity<List<QuestionWrapper>> questions= quizinterface.getQuestionFromId(questionids);
    	  
		return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<ResponseFromUser> response) {
		
		 ResponseEntity<Integer> score= quizinterface.getScore(response);
		return score;
	}
}
