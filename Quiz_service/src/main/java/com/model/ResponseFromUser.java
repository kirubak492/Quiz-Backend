package com.model;

import lombok.Data;

@Data
public class ResponseFromUser {
    
	private Integer id;
	private String response;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public ResponseFromUser(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	public ResponseFromUser() {
		
	}
	@Override
	public String toString() {
		return "ResponseFromUser [id=" + id + ", response=" + response + "]";
	}
	
}
