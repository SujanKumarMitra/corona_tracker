package com.herokuapp.corona_tracker.controller;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.corona_tracker.model.AffectedCountryList;
import com.herokuapp.corona_tracker.model.CaseByCountries;
import com.herokuapp.corona_tracker.model.LatestStatByCountryList;
import com.herokuapp.corona_tracker.model.WorldStat;

public class APIController {
	private String apiHost;
	private String apiKey;
	


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

	public APIController(String apiHost, String apiKey) {
		this.apiHost = apiHost;
		this.apiKey = apiKey;
	}

	public APIController() {

	}

	public AffectedCountryList getAffectedCountryList() {
		try {
			Response response = ClientBuilder.newClient()
					.target("https://coronavirus-monitor.p.rapidapi.com/coronavirus/affected.php")
					.queryParam("country", "india")
					.request()
					.header("x-rapidapi-host", this.apiHost)
					.header("x-rapidapi-key", this.apiKey)
					.get();
			if (response.getStatus() == 200) {
				String output = response.readEntity(String.class);
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				AffectedCountryList list = mapper.readValue(output, AffectedCountryList.class);
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public LatestStatByCountryList getLatestStatByCountry(String country) {
		try {
			Response response = ClientBuilder.newClient()
					.target("https://coronavirus-monitor.p.rapidapi.com/coronavirus/latest_stat_by_country.php")
					.queryParam("country", country)
					.request()
					.header("x-rapidapi-host", this.apiHost)
					.header("x-rapidapi-key", this.apiKey)
					.get();
			if (response.getStatus() == 200) {
				String output = response.readEntity(String.class);
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				LatestStatByCountryList list = mapper.readValue(output, LatestStatByCountryList.class);
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public WorldStat getWorldStat() {
		try {
			Response response = ClientBuilder.newClient()
					.target("https://coronavirus-monitor.p.rapidapi.com/coronavirus/worldstat.php")
					.request()
					.header("x-rapidapi-host", this.apiHost)
					.header("x-rapidapi-key", this.apiKey)
					.get();
			if (response.getStatus() == 200) {
				String output = response.readEntity(String.class);
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				WorldStat worldStat = mapper.readValue(output, WorldStat.class);
				return worldStat;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public CaseByCountries getCaseByCountries() {
		try {
			Response response = ClientBuilder.newClient()
					.target("https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php")
					.request()
					.header("x-rapidapi-host", this.apiHost)
					.header("x-rapidapi-key", this.apiKey)
					.get();
			if (response.getStatus() == 200) {
				String output = response.readEntity(String.class);
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				CaseByCountries caseByCountries = mapper.readValue(output, CaseByCountries.class);
				return caseByCountries;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
