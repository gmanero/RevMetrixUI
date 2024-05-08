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
        <form method="get">
            <% Boolean LoggedIn = (Boolean) request.getAttribute("loggedIn"); %>
            <% if (LoggedIn != null && LoggedIn) { %>
                <h1>${loggedInName}'s Statistics</h1>
            <% } else { %>
            <% } %>
        </form>
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
    int totalGames = SC.getTotalLifeTimeGames();
    int[] graph = (int[]) request.getAttribute("graphData");
	%>

    <form class="Stats" action="${pageContext.servletContext.contextPath}/stats" method="post">
    <div class="Card">
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
            <h3>Shot Statistics:</h3>
            <ul>
                <li><span class="highlight">Strikes Percentage:</span> <%= strPer %>%</li>
                <li><span class="highlight">Spares Percentage:</span> <%= spaPer %>%</li>
                <li><span class="highlight">Open Percentage:</span> <%= openPer %>%</li>
                <li><span class="highlight">Converted Splits:</span> <%= cSpl %></li>
                <li><span class="highlight">Splits:</span> <%= nSpl %></li>
                <li><span class="highlight">WashOuts:</span> <%= nWas %></li>
            </ul>    
        </div>

        <div class="infoGraphSection">
            <h3>Display Options:</h3>
            <label for="numGames">Number of Games:</label>
            <select name="numGames" id="numGames">
                <option value="5" <% if (request.getParameter("numGames") == null || request.getParameter("numGames").equals("5")) out.print("selected"); %>>5</option>
                <option value="10" <% if (request.getParameter("numGames") != null && request.getParameter("numGames").equals("10")) out.print("selected"); %>>10</option>
                <option value="15" <% if (request.getParameter("numGames") != null && request.getParameter("numGames").equals("15")) out.print("selected"); %>>15</option>
                <option value="20" <% if (request.getParameter("numGames") != null && request.getParameter("numGames").equals("20")) out.print("selected"); %>>20</option>
                <option value="25" <% if (request.getParameter("numGames") != null && request.getParameter("numGames").equals("25")) out.print("selected"); %>>25</option>
                <option value="<%= totalGames %>" <% if (request.getParameter("numGames") != null && request.getParameter("numGames").equals(String.valueOf(totalGames))) out.print("selected"); %>>Lifetime</option>
            </select>
            <input type="submit" value="Update"> 
            <br>
            <br>   
            <div id="myPlot" style="width:100%;max-width:700px"></div>    
        </div>
       </div> 
    </form>
    
    



    <!-- JavaScript code to generate the graph -->
    <script>
        // JavaScript code for plotting the graph
        <%-- Retrieve the selected number of games from the request --%>
        var numGames = <%= request.getParameter("numGames") != null ? request.getParameter("numGames") : "5" %>;
        var xArray = [];
        for (var i = 1; i <= numGames; i++) {
            xArray.push(i);
        }
        const yArray = <%= Arrays.toString(graph) %>;

        // Define Data
        const data = [{
            x: xArray,
            y: yArray,
            mode: "lines",
        }];

        // Define Layout
        const layout = {
            xaxis: {range: [1, numGames]}, // Adjust the x-axis range dynamically
            yaxis: {range: [0, 300]},
            title: "Recent Game Scores (" + numGames + ")", // Update the title dynamically
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

</body>
</html>
