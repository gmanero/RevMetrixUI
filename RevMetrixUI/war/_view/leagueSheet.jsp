<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>RevMetrix - League Sheet</title>
    <link rel="stylesheet" type="text/css" href="CSS/leagueSheet.css">
</head>
<body>

<jsp:include page="navbar.jsp" />
<%@ page import="java.util.ArrayList" %>
<%@ page import="revMetrix.db.model.LeagueSheet" %>

<div class="topPage">
    <h1>League Sheet</h1>
</div>

    <table border="1">
        <tr>
            <th>DATE</th>
            <th>LGE</th>
            <th>LANES</th>
            <th>GAME-1</th>
            <th>GAME-2</th>
            <th>GAME-3</th>
            <th>SERIES</th>
            <th>TOTAL GAMES</th>
            <th>AVERAGE</th>
            <th>STRIKES</th>
            <th>STRIKE TOTAL</th>
            <th>STRIKE AVERAGE</th>
            <th>SPARES</th>
            <th>SPARE TOTAL</th>
            <th>SPARE AVERAGE</th>
        </tr>
        <!-- Add your data rows below this line -->
        <% 
        ArrayList<LeagueSheet> leagueSheet = (ArrayList<LeagueSheet>)request.getAttribute("leagueSheet");
        for (LeagueSheet sheet : leagueSheet) { 
        %>
        <tr>
            <td><%= sheet.getDate() %></td>
            <td><%= sheet.getLge() %></td>
            <td><%= sheet.getLanes() %></td>
            <td><%= sheet.getGame1() %></td>
            <td><%= sheet.getGame2() %></td>
            <td><%= sheet.getGame3() %></td>
            <td><%= sheet.getSeries() %></td>
            <td><%= sheet.getTotalGames() %></td>
            <td><%= sheet.getAverage() %></td>
            <td><%= sheet.getStrikes() %></td>
            <td><%= sheet.getStrikeTotal() %></td>
            <td><%= String.format("%.3f", sheet.getStrikeAverage()) %></td>
            <td><%= sheet.getSpares() %></td>
            <td><%= sheet.getSpareTotal() %></td>
            <td><%= String.format("%.3f", sheet.getSpareAverage()) %></td>
        </tr>
        <% } %>
    </table>

</body>
</html>