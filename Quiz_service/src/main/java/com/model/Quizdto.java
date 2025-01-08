package com.model;

import lombok.Data;

@Data
public class Quizdto {
	String categoryName;
	Integer numQuestions;
	String Title;
	
	public Quizdto() {
		
	}
	@Override
	public String toString() {
		return "Quizdto [categoryName=" + categoryName + ", numQuestions=" + numQuestions + ", Title=" + Title + "]";
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	
	
}
