<%@page import="com.herokuapp.corona_tracker.model.LatestStatByCountry"%>
<%@page
	import="com.herokuapp.corona_tracker.model.LatestStatByCountryList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	LatestStatByCountryList list = (LatestStatByCountryList)request.getAttribute("countryData");
%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href='<c:url value="/resources/images/icon.png" />' type="image/png">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title><%=list.getCountry() %>'s Stats</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="./">COVID-19 Tracker</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<!-- <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>-->
			</ul>
			<a class="nav-link" href="./indiaStat">Stats of Indian
				States</a>
			<form class="form-inline my-2 my-lg-0" action="getCountryData">
				<input class="form-control mr-sm-2" type="search"
					name="country_name" placeholder="Enter Country Name"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<div class="container">
		<%if(list.getCountryStat().isEmpty() || list == null) {%>
		<h2>
			<p class="text-center" style="font-size: 30px;">
				No data found on
				<%=list.getCountry() %></p>
		</h2>
		<h2>
			<p class="text-center" style="font-size: 30px;">
				<a href="./">Click here</a> to go to main page
		</h2>
		<%}else { LatestStatByCountry data = list.getCountryStat().get(0); %>
		<p class="text-center" style="font-size: 30px;">
			Details about
			<%=data.getCountryName()  %></p>
		<div class="table-responsive-xl">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Properties</th>
						<th scope="col">Values</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>Total Cases</td>
						<td><%=data.getTotalCases() %></td>
					</tr>
					<tr>
						<td>Active Cases</td>
						<td><%=data.getActiveCases() %></td>
					</tr>
					<tr>
						<td>Total Deaths</td>
						<td><%=data.getTotalDeaths() %></td>
					</tr>
					<tr>
						<td>New Deaths</td>
						<td><%=data.getNewDeaths()%></td>
					</tr>
					<tr>
						<td>Total Recovered</td>
						<td><%=data.getTotalRecovered() %></td>
					</tr>
					<tr>
						<td>Critical Cases</td>
						<td><%=data.getSeriousCritical() %></td>
					</tr>
					<tr>
						<td>Last Refresh</td>
						<td><%=data.getRecordDate() %></td>
					</tr>
				</tbody>
			</table>
			<%} %>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>