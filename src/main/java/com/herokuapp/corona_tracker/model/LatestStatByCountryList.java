package com.herokuapp.corona_tracker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "country", "latest_stat_by_country" })
public class LatestStatByCountryList {

	@Override
	public String toString() {
		return "LatestStatByCountryList [country=" + country + ", lastestStatByCountries=" + lastestStatByCountries
				+ "]";
	}

	@JsonProperty("country")
	private String country;
	@JsonProperty("latest_stat_by_country")
	private List<LatestStatByCountry> lastestStatByCountries = null;

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("latest_stat_by_country")
	public List<LatestStatByCountry> getCountryStat() {
		return lastestStatByCountries;
	}

	@JsonProperty("latest_stat_by_country")
	public void setLatestStatByCountry(List<LatestStatByCountry> countryStat) {
		this.lastestStatByCountries = countryStat;
	}
}