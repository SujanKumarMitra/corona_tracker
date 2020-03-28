package com.herokuapp.corona_tracker;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.corona_tracker.model.LatestStatByCountryList;
import com.herokuapp.corona_tracker.model.WorldStat;

public class Test {

	public static void main(String[] args) {
		try {
			Response res = ClientBuilder.newClient()
					.target("https://coronavirus-monitor.p.rapidapi.com/coronavirus/latest_stat_by_country.php")
					.queryParam("country", "india")
					.request().
					header("x-rapidapi-host", "coronavirus-monitor.p.rapidapi.com")
					.header("x-rapidapi-key", "29f8d21f42mshb45ae8f903989d6p116baajsn0a2df582b297")
					.get();
			if(res.getStatus()==200) {
				String result = res.readEntity(String.class);
				ObjectMapper mapper=new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				LatestStatByCountryList data = mapper.readValue(result, LatestStatByCountryList.class);
				System.out.println(data.getCountryStat());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
