package com.herokuapp.corona_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.herokuapp.corona_tracker.controller.api.APIController;
import com.herokuapp.corona_tracker.controller.api.WebScrapper;

@Controller
public class HomeController {

	@Autowired
	APIController controller;

	@RequestMapping("/")
	public String getHome(Model model) {
		model.addAttribute("worldStat", controller.getWorldStat());
		model.addAttribute("caseByCountries", controller.getCaseByCountries());
		return "/view/index.jsp";
	}

	@RequestMapping("/home")
	public String getMain(Model model) {
		return getHome(model);
	}

	@RequestMapping("/getCountryData")
	public String getCountryData(@RequestParam("country_name") String countryName, Model model) {
		model.addAttribute("countryData", controller.getLatestStatByCountry(countryName));
		return "/view/country_data.jsp";
	}

	@RequestMapping("/indiaStat")
	public String getIndiaStat(Model model) {
		WebScrapper webScrapper = new WebScrapper();
		model.addAttribute("tableData", webScrapper.getTableData());
		model.addAttribute("tableHeader", webScrapper.getTableHeader());
		model.addAttribute("date", webScrapper.getDate());
		return "/view/india_stat.jsp";

	}

	@RequestMapping("/error")
	public String getErrorPage() {
		return "/view/error.jsp";
	}
}
