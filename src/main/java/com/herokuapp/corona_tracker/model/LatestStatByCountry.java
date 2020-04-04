package com.herokuapp.corona_tracker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "country_name", "total_cases", "new_cases", "active_cases", "total_deaths", "new_deaths",
		"total_recovered", "serious_critical", "region", "total_cases_per1m", "record_date" })
public class LatestStatByCountry {

	@JsonProperty("id")
	private String id;
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("total_cases")
	private String totalCases;
	@JsonProperty("new_cases")
	private String newCases;
	@JsonProperty("active_cases")
	private String activeCases;
	@JsonProperty("total_deaths")
	private String totalDeaths;
	@JsonProperty("new_deaths")
	private String newDeaths;
	@JsonProperty("total_recovered")
	private String totalRecovered;
	@JsonProperty("serious_critical")
	private String seriousCritical;
	@JsonProperty("region")
	private Object region;
	@JsonProperty("total_cases_per1m")
	private String totalCasesPer1m;
	@JsonProperty("record_date")
	private String recordDate;

	public LatestStatByCountry() {
		super();

	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
		if (this.id.equals("")) {
			this.id = "No Data";
		}
	}

	@JsonProperty("country_name")
	public String getCountryName() {
		return countryName;
	}

	@JsonProperty("country_name")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
		if (this.countryName.equals("")) {
			this.id = "No Data";
		}
	}

	@JsonProperty("total_cases")
	public String getTotalCases() {
		return totalCases;
	}

	@JsonProperty("total_cases")
	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
		if (this.totalCases.equals("")) {
			this.totalCases = "No Data";
		}
	}

	@JsonProperty("new_cases")
	public String getNewCases() {
		return newCases;
	}

	@JsonProperty("new_cases")
	public void setNewCases(String newCases) {
		this.newCases = newCases;
		if (this.newCases.equals("")) {
			this.newCases = "No Data";
		}
	}

	@JsonProperty("active_cases")
	public String getActiveCases() {
		return activeCases;
	}

	@JsonProperty("active_cases")
	public void setActiveCases(String activeCases) {
		this.activeCases = activeCases;
		if (this.activeCases.equals("")) {
			this.activeCases = "No Data";
		}
	}

	@JsonProperty("total_deaths")
	public String getTotalDeaths() {
		return totalDeaths;
	}

	@JsonProperty("total_deaths")
	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
		if (this.totalDeaths.equals("")) {
			this.totalDeaths = "No Data";
		}
	}

	@JsonProperty("new_deaths")
	public String getNewDeaths() {
		return newDeaths;
	}

	@JsonProperty("new_deaths")
	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
		if (this.newDeaths.equals("")) {
			this.newDeaths = "No Data";
		}
	}

	@JsonProperty("total_recovered")
	public String getTotalRecovered() {
		return totalRecovered;
	}

	@JsonProperty("total_recovered")
	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	@JsonProperty("serious_critical")
	public String getSeriousCritical() {
		return seriousCritical;
	}

	@JsonProperty("serious_critical")
	public void setSeriousCritical(String seriousCritical) {
		this.seriousCritical = seriousCritical;
		if (this.seriousCritical.equals("")) {
			this.seriousCritical = "No Data";
		}
	}

	@JsonProperty("region")
	public Object getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(Object region) {
		this.region = region;
	}

	@JsonProperty("total_cases_per1m")
	public String getTotalCasesPer1m() {
		return totalCasesPer1m;
	}

	@JsonProperty("total_cases_per1m")
	public void setTotalCasesPer1m(String totalCasesPer1m) {
		this.totalCasesPer1m = totalCasesPer1m;
		if (this.totalCasesPer1m.equals("")) {
			this.totalCasesPer1m = "No Data";
		}
	}

	@JsonProperty("record_date")
	public String getRecordDate() {
		return recordDate;
	}

	@JsonProperty("record_date")
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	@Override
	public String toString() {
		return "CountryStat [id=" + id + ", countryName=" + countryName + ", totalCases=" + totalCases + ", newCases="
				+ newCases + ", activeCases=" + activeCases + ", totalDeaths=" + totalDeaths + ", newDeaths="
				+ newDeaths + ", totalRecovered=" + totalRecovered + ", seriousCritical=" + seriousCritical
				+ ", region=" + region + ", totalCasesPer1m=" + totalCasesPer1m + ", recordDate=" + recordDate + "]";
	}

}