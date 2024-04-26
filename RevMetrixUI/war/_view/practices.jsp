<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>RevMetrix - Bowling Practices</title>
    <link rel="stylesheet" type="text/css" href="CSS/eventStyles.css">
</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="topPage">
    <h1>Practices</h1>
</div>

<%@ page import="java.util.List" %>
<%@ page import="revMetrix.db.model.Event" %>
<%@ page import="revMetrix.controller.EventController" %>

<%
    EventController controller = new EventController();
    List<Event> practices = controller.getAllPracticeEvents();
%>

<% if (!practices.isEmpty()) { %>
    <div class="eventCards">
        <% for (Event event : practices) { %>
            <div class="eventCard">
                <h2><%= event.getName() %></h2>
                <p><strong>Establishment:</strong> <%= event.getEstablishmentName() %></p>
                <p><strong>Description:</strong> <%= event.getDescription() %></p>
            </div>
        <% } %>
    </div>
<% } else { %>
    <p>No events found.</p>
<% } %>

</body>
</html>
