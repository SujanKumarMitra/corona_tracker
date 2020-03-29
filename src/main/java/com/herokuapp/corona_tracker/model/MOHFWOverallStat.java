package com.herokuapp.corona_tracker.model;

import java.util.ArrayList;

public class MOHFWOverallStat {
	private String totalConfirmedCases;
	private String cured;
	private String death;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public MOHFWOverallStat() {
		super();
	}
	public MOHFWOverallStat(ArrayList<String> data) {
		setTotalConfirmedCases(data.get(1));
		setCured(data.get(2));
		setDeath(data.get(3));
	}

	public String getTotalConfirmedCases() {
		return totalConfirmedCases;
	}

	public void setTotalConfirmedCases(String totalConfirmedCases) {
		this.totalConfirmedCases = totalConfirmedCases;
	}

	public String getCured() {
		return cured;
	}

	public void setCured(String cured) {
		this.cured = cured;
	}

	public String getDeath() {
		return death;
	}

	public void setDeath(String death) {
		this.death = death;
	}
	@Override
	public String toString() {
		return "MOHFWOverallStat [totalConfirmedCases=" + totalConfirmedCases + ", cured=" + cured + ", death=" + death
				+ ", date=" + date + "]";
	}

	
}
