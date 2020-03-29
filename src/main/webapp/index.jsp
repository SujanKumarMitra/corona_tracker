<%@page import="com.herokuapp.corona_tracker.controller.APIController"%>
<%@page import="com.herokuapp.corona_tracker.model.CountryStat"%>
<%@page import="java.util.List"%>
<%@page import="com.herokuapp.corona_tracker.model.CaseByCountries"%>
<%@page import="com.herokuapp.corona_tracker.model.AffectedCountryList"%>
<%@page import="com.herokuapp.corona_tracker.model.WorldStat"%>
<%@page errorPage="error.jsp" %>
<%

	String apiHost = getServletContext().getInitParameter("host");
	String apiKey = getServletContext().getInitParameter("key");
	APIController controller = new APIController(apiHost,apiKey);
	WorldStat worldStat = controller.getWorldStat();
	AffectedCountryList affectedCountryList = controller.getAffectedCountryList();
	List<String> countryList = affectedCountryList.getAffectedCountries();
	CaseByCountries caseByCountries = controller.getCaseByCountries();
	List<CountryStat> countryStat = caseByCountries.getCountriesStat();
%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="./icon.png" type="image/png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Covid-19 Tracker</title>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">COVID-19 Tracker</a>
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
            <form class="form-inline my-2 my-lg-0" action="GetCountryData" method="GET">
                <input class="form-control mr-sm-2" name="country_name" type="search" placeholder="Enter Country Name" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
        </div>
    </nav>
    
    
    <div class="jumbotron">
        
        <center>
            <h1 class="display-4">COVID-19 Global Statistics</h1>
            <hr class="my-4">
            <p class="lead">TOTAL CASES WORLDWIDE: <%=worldStat.getTotalCases() %></p>
            <p class="lead">TOTAL DEATHS: <%= worldStat.getTotalDeaths() %></p>
            <p class="lead">TOTAL RECOVERED: <%=worldStat.getTotalRecovered() %></p>
            <hr class="my-4">
            <p class="Lead">Enter Country Name to get Details about a specific country </p>
            <div style="top: 50%; left: 50%;">
            <form class="my-2 my-lg-0 sm" action="india_stat.jsp" method="GET">
                <input style="width: auto;" class="form-control mr-sm-2" name="country_name" type="search" placeholder="Enter Country Name" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
              </form>
            </div>
             <p class="Lead">OR</p>
             <p class="Lead"><a href="india_stat.jsp">CLick Here</a> to See Stats of Indian States</p>
        </center>
        </div>
        <div class="container mx-auto">
            <p class="text-center" style="font-size: 30px;">Country Wise Stats:</p>
            <div class="table-responsive-xl">
                <table class="table">
                    <thead class="thead-dark">
                      <tr>
                        <th scope="col">Country Name</th>
                        <th scope="col">Cases</th>
                        <th scope="col">Deaths</th>
                        <th scope="col">Recovered</th>
                        <th scope="col">New Cases</th>
                        <th scope="col">New Deaths</th>
                        <th scope="col">Active Cases</th>
                        <th scope="col">Critical Condition</th>
                      </tr>
                    </thead>
                    <tbody>
                    <% for(CountryStat stat :countryStat) {  %>
                      <tr>
                        
                        <td><%=stat.getCountryName() %></td>
                        <td><%= stat.getCases() %></td>
                        <td><%=stat.getDeaths() %></td>
                        <td><%=stat.getTotalRecovered() %></td>
                        <td><%=stat.getNewCases() %></td>
                        <td><%=stat.getNewDeaths() %></td>
                        <td><%=stat.getActiveCases() %></td>
                        <td><%=stat.getSeriousCritical() %></td>
                       
                      </tr>
                       <%} %>
                    </tbody>
                  </table>
            </div>
        </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>

</html>