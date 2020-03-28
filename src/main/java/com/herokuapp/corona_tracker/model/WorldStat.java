package com.herokuapp.corona_tracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "total_cases", "total_deaths", "total_recovered", "new_cases", "new_deaths",
		"statistic_taken_at" })
public class WorldStat {

	@JsonProperty("total_cases")
	private String totalCases;
	@JsonProperty("total_deaths")
	private String totalDeaths;
	@JsonProperty("total_recovered")
	private String totalRecovered;
	@JsonProperty("new_cases")
	private String newCases;
	@JsonProperty("new_deaths")
	private String newDeaths;
	@JsonProperty("statistic_taken_at")
	private String statisticTakenAt;

	@JsonProperty("total_cases")
	public String getTotalCases() {
		return totalCases;
	}

	@JsonProperty("total_cases")
	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	@JsonProperty("total_deaths")
	public String getTotalDeaths() {
		return totalDeaths;
	}

	@JsonProperty("total_deaths")
	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	@JsonProperty("total_recovered")
	public String getTotalRecovered() {
		return totalRecovered;
	}

	@JsonProperty("total_recovered")
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	@JsonProperty("new_cases")
	public String getNewCases() {
		return newCases;
	}

	@JsonProperty("new_cases")
	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}

	@JsonProperty("new_deaths")
	public String getNewDeaths() {
		return newDeaths;
	}

	@JsonProperty("new_deaths")
	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}

	@JsonProperty("statistic_taken_at")
	public String getStatisticTakenAt() {
		return statisticTakenAt;
	}

	@JsonProperty("statistic_taken_at")
	public void setStatisticTakenAt(String statisticTakenAt) {
		this.statisticTakenAt = statisticTakenAt;
	}

	@Override
	public String toString() {
		return "WorldStat [totalCases=" + totalCases + ", totalDeaths=" + totalDeaths + ", totalRecovered="
				+ totalRecovered + ", newCases=" + newCases + ", newDeaths=" + newDeaths + ", statisticTakenAt="
				+ statisticTakenAt + "]";
	}
}