package com.anirban.entity;

public class ResponseStructure<T> {
	
	String message;
	private int statuscode;
	private T data;
	public ResponseStructure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseStructure(String message, int statuscode, T data) {
		super();
		this.message = message;
		this.statuscode = statuscode;
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseStructure [message=" + message + ", statuscode=" + statuscode + ", data=" + data + "]";
	}
	
	
}
