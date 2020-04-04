package com.herokuapp.corona_tracker.controller.api;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.corona_tracker.model.AffectedCountryList;
import com.herokuapp.corona_tracker.model.CaseByCountries;
import com.herokuapp.corona_tracker.model.LatestStatByCountryList;
import com.herokuapp.corona_tracker.model.WorldStat;

@Component
public class APIController {
	@Override
	public String toString() {
		return "APIController [properties=" + properties + "]";
	}

	@Autowired
	APIProperties properties;

	public AffectedCountryList getAffectedCountryList() {
		try {
			Response response = ClientBuilder.newClient().target(properties.getWorldStatUrl()).request()
					.header("x-rapidapi-host", properties.getApiHost()).header("x-rapidapi-key", properties.getApiKey())
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
			Response response = ClientBuilder.newClient().target(properties.getLatestStatByCountryUrl())
					.queryParam("country", country).request().header("x-rapidapi-host", properties.getApiHost())
					.header("x-rapidapi-key", properties.getApiKey()).get();
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
			Response response = ClientBuilder.newClient().target(properties.getWorldStatUrl()).request()
					.header("x-rapidapi-host", properties.getApiHost()).header("x-rapidapi-key", properties.getApiKey())
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
			Response response = ClientBuilder.newClient().target(properties.getCaseByCountriesUrl()).request()
					.header("x-rapidapi-host", properties.getApiHost()).header("x-rapidapi-key", properties.getApiKey())
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
