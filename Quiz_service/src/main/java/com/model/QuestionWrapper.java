package com.model;

import lombok.Data;

@Data
public class QuestionWrapper {
	private Integer id;
	private String question_title;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public QuestionWrapper() {
		
	}
	public QuestionWrapper(Integer id, String question_title, String op1, String op2, String op3, String op4) {
		super();
		this.id = id;
		this.question_title = question_title;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
	}
	
	
}
