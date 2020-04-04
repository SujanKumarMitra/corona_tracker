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
			Elements rowData = document.getElementsByClass("data-table table-responsive").get(0)
					.getElementsByTag("tbody").get(0).getElementsByTag("tr");
//			System.out.println(rowData);

			for (Element rows : rowData) {
				Elements row = rows.getElementsByTag("td");
				ArrayList<String> rowValue = new ArrayList<String>();
				for (Element data : row) {
					rowValue.add(data.text());
				}
				this.tableData.add(rowValue);
			}

			return tableData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ArrayList<String> setTableHeader() {
		try {
			Elements tableRow = document.getElementsByClass("data-table table-responsive").get(0)
					.getElementsByTag("th");
//			System.out.println(tableRow.html());
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
			Elements dateRow = document.getElementsByClass("status-update").get(0).getElementsByTag("span");
			String date = dateRow.text().substring("as on : ".length(), dateRow.text().length());
//			System.out.println(date);
			this.date = date;
		} catch (Exception e) {
			date = "";
		}
	}

	public static void main(String[] args) {
		WebScrapper obj = new WebScrapper();
//		System.out.println(obj.getTableHeader());
//		System.out.println(obj.getTableData());
//		System.out.println(obj.getDate());

	}
}
