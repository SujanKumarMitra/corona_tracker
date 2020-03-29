package com.herokuapp.corona_tracker.controller;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.herokuapp.corona_tracker.model.State;

public class WebScrapper {

	private String url = "https://www.mohfw.gov.in";
	private ArrayList<State> tableData = null;
	private ArrayList<String> tableHeader = null;
	private State totalStat = null;

	public ArrayList<State> getTableData() {
		return tableData;
	}

	public ArrayList<String> getTableHeader() {
		return tableHeader;
	}

	public State getTotalStat() {
		return totalStat;
	}

	public WebScrapper() {
		super();
		this.totalStat = new State();
		this.tableData = new ArrayList<>();
		this.tableHeader = new ArrayList<>();
		this.tableData = setTableData();
		this.tableHeader = setTableHeader();
	}

	private ArrayList<State> setTableData() {
		try {
			Document document = Jsoup.connect(this.url).get();
			Elements tableBody = document.getElementById("cases").getElementsByClass("table-responsive").get(0)
					.getElementsByTag("tbody");
			System.out.println(tableBody);
			for (Element row : tableBody) {
				Elements tableRow = row.getElementsByTag("tr");
				for (Element rows : tableRow) {
					Elements rowData = rows.getElementsByTag("td");
					ArrayList<String> rowValueList = new ArrayList<>();
					for (Element tmp : rowData) {
						rowValueList.add(tmp.text());
					}
					State state = new State();
					state.setValues(rowValueList);
					this.tableData.add(state);
				}
			}
			this.totalStat = tableData.get(tableData.size() - 1);
			tableData.remove(tableData.size() - 1);
			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ArrayList<String> setTableHeader() {
		try {
			Document document = Jsoup.connect(this.url).get();
			Elements tableRow = document.getElementById("cases").getElementsByClass("table-responsive").get(0)
					.getElementsByTag("th");
			for (Element rowData : tableRow) {
				this.tableHeader.add(rowData.text());
			}
			return this.tableHeader;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		WebScrapper obj = new WebScrapper();
		System.out.println(obj.getTableHeader());
		System.out.println(obj.getTableData());
		System.out.println(obj.getTotalStat());
	}
}
