<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>RevMetrix - Bowling Leagues</title>
    <link rel="stylesheet" type="text/css" href="CSS/eventStyles.css">
</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="topPage">
    <h1>Leagues</h1>
</div>

<%@ page import="java.util.List" %>
<%@ page import="revMetrix.db.model.Event" %>
<%@ page import="revMetrix.controller.EventController" %>

<%
    EventController controller = new EventController();
    List<Event> leagues = controller.getAllOngoingLeagueEvents();
%>

<% if (!leagues.isEmpty()) { %>
<form method="get">
    <div class="eventCards">
        <% for (Event event : leagues) {  if(event.getEventId()!=6){%>
            <a href="index?destination=eventDetails&id=<%= event.getEventId() %>">
                <div class="eventCard">
                    <h2><%= event.getName() %></h2>
                    <p><strong>Establishment:</strong> <%= event.getEstablishmentName() %></p>
                    <p><strong>Type:</strong> <%= event.getTypeString() %></p>
                    <p><strong>Description:</strong> <%= event.getDescription() %></p>
                    <p><strong>Start Date:</strong> <%= event.getStartdate() %></p>
                </div>
            </a>
        <% }} %>
    </div>
    </form>
<% } else { %>
    <p>No events found.</p>
<% } %>

</body>
</html>
