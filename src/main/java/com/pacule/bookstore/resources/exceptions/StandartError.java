package com.pacule.bookstore.resources.exceptions;

public class StandartError {

	private long timestamp;
	private Integer status;
	private String error;

	public StandartError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandartError(long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
