package com.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String Title;
	
	@ElementCollection
	private List<Integer> questionsIds;
	
	public Quiz() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public List<Integer> getQuestionsIds() {
		return questionsIds;
	}

	public void setQuestionsIds(List<Integer> questionsIds) {
		this.questionsIds = questionsIds;
	}

	public Quiz(Integer id, String title, List<Integer> questionsIds) {
		super();
		this.id = id;
		this.Title = title;
		this.questionsIds = questionsIds;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", Title=" + Title + ", questionsIds=" + questionsIds + "]";
	}
	
	
}
