package com.herokuapp.corona_tracker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"country",
"stat_by_country"
})
public class CountryHistoryByDate {

@Override
	public String toString() {
		return "CountryHistoryByDate [country=" + country + ", statByCountry=" + statByCountry + "]";
	}

@JsonProperty("country")
private String country;
@JsonProperty("stat_by_country")
private List<LatestStatByCountry> statByCountry = null;

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("stat_by_country")
public List<LatestStatByCountry> getStatByCountry() {
return statByCountry;
}

@JsonProperty("stat_by_country")
public void setStatByCountry(List<LatestStatByCountry> statByCountry) {
this.statByCountry = statByCountry;
}

}