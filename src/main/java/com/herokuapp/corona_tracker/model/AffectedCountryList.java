package com.herokuapp.corona_tracker.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "affected_countries", "statistic_taken_at" })
public class AffectedCountryList {

	@Override
	public String toString() {
		return "AffectedCountryList [affectedCountries=" + affectedCountries + ", statisticTakenAt=" + statisticTakenAt
				+ "]";
	}

	@JsonProperty("affected_countries")
	private List<String> affectedCountries = null;
	@JsonProperty("statistic_taken_at")
	private String statisticTakenAt;

	@JsonProperty("affected_countries")
	public List<String> getAffectedCountries() {
		return affectedCountries;
	}

	@JsonProperty("affected_countries")
	public void setAffectedCountries(List<String> affectedCountries) {
		this.affectedCountries = affectedCountries;
	}

	@JsonProperty("statistic_taken_at")
	public String getStatisticTakenAt() {
		return statisticTakenAt;
	}

	@JsonProperty("statistic_taken_at")
	public void setStatisticTakenAt(String statisticTakenAt) {
		this.statisticTakenAt = statisticTakenAt;
	}

}
