package com.herokuapp.corona_tracker.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "countries_stat", "statistic_taken_at" })
public class CaseByCountries {

	@Override
	public String toString() {
		return "CaseByCountries [countryStats=" + countryStats + ", statisticTakenAt=" + statisticTakenAt + "]";
	}

	@JsonProperty("countries_stat")
	private List<CountryStat> countryStats = null;
	@JsonProperty("statistic_taken_at")
	private String statisticTakenAt;

	@JsonProperty("countries_stat")
	public List<CountryStat> getCountriesStat() {
		Collections.sort(countryStats, new Comparator<CountryStat>() {

			@Override
			public int compare(CountryStat o1, CountryStat o2) {
				String str1 = o1.getCases();
				String str2 = o2.getCases();
				str1 = str1.replace(",", "");
				str2 = str2.replace(",", "");
				if (Integer.parseInt(str1) > Integer.parseInt(str2)) {
					return -1;
				} else {
					return 1;
				}
			}

		});
		;
		return countryStats;
	}

	@JsonProperty("countries_stat")
	public void setCountriesStat(List<CountryStat> countriesStat) {
		this.countryStats = countriesStat;
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
