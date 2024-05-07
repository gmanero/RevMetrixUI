<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Statistics</title>
    <link rel="stylesheet" type="text/css" href="CSS/statsStyles.css">
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <%@ page import="java.util.List" %>
	<%@ page import="java.util.Arrays" %>
	<%@ page import="revMetrix.controller.StatsController" %>
	<%@ page import="revMetrix.db.model.Game" %>
	
    <div class="topPage">
        <h1>Take a look at Statistics</h1>
    </div>
    
    <%
    StatsController SC = new StatsController();
    List<Game> gamelist = SC.getAllGames();
    double gameScore = SC.getTotalGameScore();
    double gameScore123 = SC.getLastThreeGameScore();
    int tStr = SC.getTotalStrikes();
    int tSpa = SC.getTotalSpares();
    double strPer = SC.getStrikesPercentage();
    double spaPer = SC.getSparesPercentage();
    double openPer = SC.getOpenPercentage();
    int high = SC.highestGameScore();
    int low = SC.lowestGameScore();
    int tTur = SC.getTurkeys();
    int cSpl = SC.splitsConversion();
    int nSpl = SC.numSplit();
    int nWas = SC.numWashout();
    int[] graph = SC.getGraphData();
	%>

    <form class="Stats" action="${pageContext.servletContext.contextPath}/stats" method="post">
        <div class="infoSection">
            <h3>Game Statistics:</h3>
            <ul>
                <li><span class="highlight">Average Game Score (From All Games):</span> <%= gameScore %></li>
                <li><span class="highlight">Average Game Score (From Last Three Games played):</span> <%= gameScore123 %></li>
                <li><span class="highlight">Highest Game Score:</span> <%= high %></li>
                <li><span class="highlight">Lowest Game Score:</span> <%= low %></li>
                <li><span class="highlight">Total Strike:</span> <%= tStr %></li>
                <li><span class="highlight">Total Spares:</span> <%= tSpa %></li>
                <li><span class="highlight">Total Turkeys:</span> <%= tTur %></li>
            </ul>
        </div>
        
        
        <div class="infoSection">
        	<ul>
	        	<h3>Shot Statistics:</h3>
	            <li><span class="highlight">Strikes Percentage:</span> <%= strPer %>%</li>
	            <li><span class="highlight">Spares Percentage:</span> <%= spaPer %>%</li>
	            <li><span class="highlight">Open Percentage:</span> <%= openPer %>%</li>
	            <li><span class="highlight">Splits:</span> <%= nSpl %></li>
	            <li><span class="highlight">Converted Splits:</span> <%= cSpl %></li>
	            <li><span class="highlight">WashOuts:</span> <%= nWas %></li>
        	</ul>          
        </div>
        
        
    </form>
    
    <div class="infoSection">
	    <div class="dropdown">
		    <button class="dropbtn">Select # of Games</button>
			    <div class="dropdown-content">
			        <a href="#" data-value="5">past 5</a>
		        	<a href="#" data-value="50">past 50</a>
		        	<a href="#" data-value="100">past 100</a>
			    </div>
    </div>
    
    
</div>

<div class="infoSectionGraph">

<div id="myPlot" style="width:100%;max-width:700px"></div>
</div>


<script>


	
const xArray = [1,2,3,4,5];
const yArray = <%= Arrays.toString(graph) %>;

// Define Data
const data = [{
  x: xArray,
  y: yArray,
  mode:"lines",
  
}];

// Define Layout
const layout = {
  xaxis: {range: [1, 5]},
  yaxis: {range: [0, 300]},  
  title: "Recent Game Scores (5)",
  plot_bgcolor: "#1f1f1f",  
  
  paper_bgcolor: "#1f1f1f",
  titlefont: {
      color: 'white' 
  },
  xaxis: {
      tickfont: {
          color: 'white'
      }
  }
};

// Display using Plotly
Plotly.newPlot("myPlot", data, layout);
</script>


	<input type="text" id="SetGame" name="SetGame" placeholder="Enter Set # Game: EX: 43">
		


</body>
</html>