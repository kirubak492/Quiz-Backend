package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.model.QuestionWrapper;

import com.model.ResponseFromUser;
import com.dao.QuestionDao;
import com.model.Question;

@Service
public class Question_service {

	@Autowired
    QuestionDao questiondao;
	
	public ResponseEntity<List<Question>> getAllquestions() {
		try {
		return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>>getquestionbycategory(String category) {
		try {
		return new ResponseEntity<>(questiondao.findByCategory(category),HttpStatus.OK);
	   }
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<String> addquestion(Question question) {
		// TODO Auto-generated method stub
		questiondao.save(question);
		return new ResponseEntity<>("Question added successfully",HttpStatus.CREATED);
	}

	public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numQuestions) {
		
		List<Integer> questions= questiondao.findRandomQuestionByCategory(categoryName,numQuestions);

		return new ResponseEntity<>(questions,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionIds) {
		
		List<QuestionWrapper> wrappers=new ArrayList<>();
		List<Question>questions =new ArrayList<>();
		
		for(Integer id:questionIds) {
			questions.add(questiondao.findById(id).get());
		}
		
		for(Question question:questions) {
			
			QuestionWrapper wrapper =new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestion_title(question.getQuestion_title());
			wrapper.setOp1(question.getOp1());
			wrapper.setOp2(question.getOp2());
			wrapper.setOp3(question.getOp3());
			wrapper.setOp4(question.getOp4());
			
			wrappers.add(wrapper);
			
		}
		
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<ResponseFromUser> responses) {
		
		int right=0;
		
		for(ResponseFromUser rs: responses)
		{
			Question question=questiondao.findById(rs.getId()).get();
			if(rs.getResponse().equals(question.getRight_answer()))
			{
				right++;
			}
			
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

	
}
