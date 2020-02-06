package com.cardsys.vo;

public class SearchVO {
	private String name;
	
	private String state;
	
	private String startDate;
	
	private String endDate;
	
	private String luruStartDate;
	
	private String luruEndDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLuruStartDate() {
		return luruStartDate;
	}

	public void setLuruStartDate(String luruStartDate) {
		this.luruStartDate = luruStartDate;
	}

	public String getLuruEndDate() {
		return luruEndDate;
	}

	public void setLuruEndDate(String luruEndDate) {
		this.luruEndDate = luruEndDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
