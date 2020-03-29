<%@page import="com.herokuapp.corona_tracker.model.State"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.herokuapp.corona_tracker.controller.WebScrapper"%>
<%@page import="com.herokuapp.corona_tracker.model.LatestStatByCountry"%>
<%@page import="com.herokuapp.corona_tracker.model.LatestStatByCountryList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page errorPage="error.jsp" %>
<%
	WebScrapper scrapper = new WebScrapper();
	ArrayList<State> tableData = scrapper.getTableData();
	State overallStat = scrapper.getTotalStat();
%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="./icon.png" type="image/png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Stat of Indian States</title>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="index.jsp">COVID-19 Tracker</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <!-- <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>-->
            </ul>
            <a class="nav-link" href="india_stat.jsp">Stats of Indian States</a>
            <form class="form-inline my-2 my-lg-0" action="GetCountryData">
                <input class="form-control mr-sm-2" type="search" name="country_name" placeholder="Enter Country Name" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
        </div>
    </nav>
    <div class="jumbotron">
        
        <center>
            <h1 class="display-4">COVID-19 India's Statistics</h1>
            <hr class="my-4">
            <p class="lead">TOTAL CONFIRMED CASES OF INDIANS: <%= overallStat.getConfirmedIndian()  %></p>
            <p class="lead">TOTAL CONFIRMED CASES OF FOREIGNERS: <%= overallStat.getConfirmedForeign()  %></p>
            <p class="lead">TOTAL DEATHS: <%= overallStat.getDeath() %></p>
            <p class="lead">TOTAL RECOVERED: <%=overallStat.getCured() %></p>
           <!--  <hr class="my-4"> -->
            <!-- <p class="Lead">Enter Country Name to get Details about a specific country </p>
            <div style="top: 50%; left: 50%;">
            <form class="my-2 my-lg-0 sm" action="GetCountryData" method="GET">
                <input style="width: auto;" class="form-control mr-sm-2" name="country_name" type="search" placeholder="Enter Country Name" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div> -->
        </center>
        </div>
    <div class="container">
    	<p class="text-center" style="font-size: 30px;">Details about Indian States and Territories</p>
    	<p class="text-center" style="font-size: 30px;">Data is synchronized with <a href="https://www.mohfw.gov.in/">MOHFW</a> </p>
    	<div class="table-responsive-lg">
                <table class="table">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col">Sl No.</th>
                         <th scope="col">State/Territory</th>
                          <th scope="col">Confirmed(Indian)</th>
                           <th scope="col">Confirmed(Foreign)</th>
                            <th scope="col">Cured</th>
                             <th scope="col">Death</th>
                      </tr>
                    </thead>
                    <tbody>
                    	<%for(State row:tableData) { %>
                    		<tr>
                    			<td><%=row.getId() %></td>
                    			<td><%=row.getName() %></td>
                    			<td><%=row.getConfirmedIndian() %></td>
                    			<td><%=row.getConfirmedForeign() %></td>
                    			<td><%=row.getCured() %></td>
                    			<td><%=row.getDeath() %></td>
                    		</tr>
                    	<%} %>
                    </tbody>
                  </table>
            </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>