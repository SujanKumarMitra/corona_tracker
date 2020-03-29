package com.herokuapp.corona_tracker.model;

import java.util.ArrayList;

public class State {
	private String id;
	private String name;
	private String confirmedIndian;
	private String confirmedForeign;
	private String cured;
	private String death;
	
	public State() {
		super();
	}
	public State(String id, String name, String confirmedIndian, String confirmedForeign, String cured, String death) {
		super();
		this.id = id;
		this.name = name;
		this.confirmedIndian = confirmedIndian;
		this.confirmedForeign = confirmedForeign;
		this.cured = cured;
		this.death = death;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConfirmedIndian() {
		return confirmedIndian;
	}
	public void setConfirmedIndian(String confirmedIndian) {
		this.confirmedIndian = confirmedIndian;
	}
	public String getConfirmedForeign() {
		return confirmedForeign;
	}
	public void setConfirmedForeign(String confirmedForeign) {
		this.confirmedForeign = confirmedForeign;
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
		return "State [id=" + id + ", name=" + name + ", confirmedIndian=" + confirmedIndian + ", confirmedForeign="
				+ confirmedForeign + ", cured=" + cured + ", death=" + death + "]";
	}
	
	public void setValues(ArrayList<String> data) {
		if(data.size()==6) {
			this.setId(data.get(0));
			this.setName(data.get(1));
			this.setConfirmedIndian(data.get(2));
			this.setConfirmedForeign(data.get(3));
			this.setCured(data.get(4));
			this.setDeath(data.get(5));
		}
		else if(data.size()==5) {
			this.setName(data.get(0));
			this.setConfirmedIndian(data.get(1));
			this.setConfirmedForeign(data.get(2));
			this.setCured(data.get(3));
			this.setDeath(data.get(4));
		}
	}

}
