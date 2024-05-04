<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>RevMetrix - Bowling Events</title>
    <link rel="stylesheet" type="text/css" href="CSS/eventStyles.css">
</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="topPage">
    <h1>Bowling Events</h1>
</div>

<%@ page import="java.util.List" %>
<%@ page import="revMetrix.db.model.Event" %>
<%@ page import="revMetrix.controller.EventController" %>

<%
    EventController controller = new EventController();
    List<Event> events = controller.getAllEvents();
%>

<% if (!events.isEmpty()) { %>
<form method="get">
    <div class="eventCards">
        <% for (Event event : events) { %>
            <a href="index?destination=eventDetails&id=<%= event.getEventId() %>">
                <div class="eventCard">
                    <h2><%= event.getName() %></h2>
                    <p><strong>Establishment:</strong> <%= event.getEstablishmentName() %></p>
                    <p><strong>Type:</strong> <%= event.getTypeString() %></p>
                    <p><strong>Description:</strong> <%= event.getDescription() %></p>
                </div>
            </a>
        <% } %>
    </div>
    </form>
<% } else { %>
    <p>No events found.</p>
<% } %>

<li><span class="highlight">Total Strike:</span> <%= request.getAttribute("strikesPerGame") %></li>
				<li><span class="highlight">Total Spare:</span> <%= request.getAttribute("sparesPerGame") %></li>

</body>
</html>
