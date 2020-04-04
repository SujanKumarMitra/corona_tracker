package com.herokuapp.corona_tracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "country_name", "cases", "deaths", "region", "total_recovered", "new_deaths", "new_cases",
		"serious_critical", "active_cases", "total_cases_per_1m_population" })
public class CountryStat {

	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("cases")
	private String cases;
	@JsonProperty("deaths")
	private String deaths;
	@JsonProperty("region")
	private String region;
	@JsonProperty("total_recovered")
	private String totalRecovered;
	@JsonProperty("new_deaths")
	private String newDeaths;
	@JsonProperty("new_cases")
	private String newCases;
	@JsonProperty("serious_critical")
	private String seriousCritical;
	@JsonProperty("active_cases")
	private String activeCases;
	@JsonProperty("total_cases_per_1m_population")
	private String totalCasesPer1mPopulation;

	@JsonProperty("country_name")
	public String getCountryName() {
		return countryName;
	}

	@JsonProperty("country_name")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@JsonProperty("cases")
	public String getCases() {
		return cases;
	}

	@JsonProperty("cases")
	public void setCases(String cases) {
		this.cases = cases;
	}

	@JsonProperty("deaths")
	public String getDeaths() {
		return deaths;
	}

	@JsonProperty("deaths")
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("total_recovered")
	public String getTotalRecovered() {
		return totalRecovered;
	}

	@JsonProperty("total_recovered")
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	@JsonProperty("new_deaths")
	public String getNewDeaths() {
		return newDeaths;
	}

	@JsonProperty("new_deaths")
	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}

	@JsonProperty("new_cases")
	public String getNewCases() {
		return newCases;
	}

	@JsonProperty("new_cases")
	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}

	@JsonProperty("serious_critical")
	public String getSeriousCritical() {
		return seriousCritical;
	}

	@JsonProperty("serious_critical")
	public void setSeriousCritical(String seriousCritical) {
		this.seriousCritical = seriousCritical;
	}

	@JsonProperty("active_cases")
	public String getActiveCases() {
		return activeCases;
	}

	@JsonProperty("active_cases")
	public void setActiveCases(String activeCases) {
		this.activeCases = activeCases;
	}

	@JsonProperty("total_cases_per_1m_population")
	public String getTotalCasesPer1mPopulation() {
		return totalCasesPer1mPopulation;
	}

	@JsonProperty("total_cases_per_1m_population")
	public void setTotalCasesPer1mPopulation(String totalCasesPer1mPopulation) {
		this.totalCasesPer1mPopulation = totalCasesPer1mPopulation;
	}

	@Override
	public String toString() {
		return "CountryStatDetails [countryName=" + countryName + ", cases=" + cases + ", deaths=" + deaths
				+ ", region=" + region + ", totalRecovered=" + totalRecovered + ", newDeaths=" + newDeaths
				+ ", newCases=" + newCases + ", seriousCritical=" + seriousCritical + ", activeCases=" + activeCases
				+ ", totalCasesPer1mPopulation=" + totalCasesPer1mPopulation + "]";
	}
}