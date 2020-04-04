package com.herokuapp.corona_tracker.controller.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class APIProperties {

	@Value("${api_host}")
	private String apiHost;

	@Value("${api_key}")
	private String apiKey;

	@Value("${world_stat_url}")
	private String worldStatUrl;

	@Value("${case_by_countries_url}")
	private String caseByCountriesUrl;

	@Value("${latest_stat_by_country_url}")
	private String latestStatByCountryUrl;

	public String getApiHost() {
		return apiHost;
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getWorldStatUrl() {
		return worldStatUrl;
	}

	public void setWorldStatUrl(String worldStatUrl) {
		this.worldStatUrl = worldStatUrl;
	}

	public String getCaseByCountriesUrl() {
		return caseByCountriesUrl;
	}

	public void setCaseByCountriesUrl(String caseByCountriesUrl) {
		this.caseByCountriesUrl = caseByCountriesUrl;
	}

	public String getLatestStatByCountryUrl() {
		return latestStatByCountryUrl;
	}

	public void setLatestStatByCountryUrl(String latestStatByCountryUrl) {
		this.latestStatByCountryUrl = latestStatByCountryUrl;
	}

	@Override
	public String toString() {
		return "APIProperties [apiHost=" + apiHost + ", apiKey=" + apiKey + ", worldStatUrl=" + worldStatUrl
				+ ", caseByCountriesUrl=" + caseByCountriesUrl + ", latestStatByCountryUrl=" + latestStatByCountryUrl
				+ "]";
	}

}
