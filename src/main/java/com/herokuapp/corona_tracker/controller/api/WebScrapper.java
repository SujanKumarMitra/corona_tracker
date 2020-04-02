package com.herokuapp.corona_tracker.controller.api;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


public class WebScrapper {

	private String url = "https://www.mohfw.gov.in";
	private ArrayList<ArrayList<String>> tableData = null;
	private Document document = null;
	private ArrayList<String> tableHeader = null;
	private String date;
	

	public ArrayList<ArrayList<String>> getTableData() {
		return tableData;
	}

	public ArrayList<String> getTableHeader() {
		return tableHeader;
	}
	public String getDate() {
		return date;
	}

	public WebScrapper() {
		super();
		try {
			document = Jsoup.connect(this.url).get();
		} catch (IOException e) {
			return;
		}
		this.tableData = new ArrayList<>();
		this.tableHeader = new ArrayList<>();
		this.tableData = setTableData();
		this.tableHeader = setTableHeader();
		setDate();
	}

	private ArrayList<ArrayList<String>> setTableData() {
		try {
			Elements tableBody = document.getElementById("cases").getElementsByClass("table-responsive").get(0)
					.getElementsByTag("tbody");
			for (Element row : tableBody) {
				Elements tableRow = row.getElementsByTag("tr");
				for (Element rows : tableRow) {
					Elements rowData = rows.getElementsByTag("td");
					ArrayList<String> rowValueList = new ArrayList<>();
					for (Element tmp : rowData) {
						rowValueList.add(tmp.text());
					}
					this.tableData.add(rowValueList);
				}
			}
			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ArrayList<String> setTableHeader() {
		try {
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
	private void setDate() {
		try {
			Elements dateRow = document.getElementById("cases").getElementsByClass("content newtab").get(0).getElementsByTag("p").get(0).getElementsByTag("strong");
			String date = dateRow.text().substring(dateRow.text().length() - "00.00.0000 at 00:00 PM)".length(),dateRow.text().length()-1);
			this.date=date;
		} catch (Exception e) {
			date = "";
		}
	}
	public static void main(String[] args) {
		WebScrapper obj = new WebScrapper();
		obj.setDate();
	}
}
