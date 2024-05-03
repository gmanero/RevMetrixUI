<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Event Details</title>
    <link rel="stylesheet" type="text/css" href="CSS/eventDetailsStyles.css"> <!-- Linking CSS file -->
</head>
<body>


<jsp:include page="navbar.jsp" />


    <%@ page import="revMetrix.controller.EventController" %>
    <%@ page import="revMetrix.db.model.Event" %>
    <%@ page import="java.util.ArrayList" %>

    <%
        int eventId = Integer.parseInt(request.getParameter("id"));
        EventController controller = new EventController();
        ArrayList<Event> events = controller.findEventByID(eventId);
        Event event = events.get(0); // Since findEventByID returns a list, get the first event
    %>
    
    <div class="topPage">
    <h1><%= event.getName() %></h1>
</div>
<div class="container">

    <div class="event-details">
        <h1>Event Details</h1>
        <p><strong>Establishment:</strong> <%= event.getEstablishmentName() %></p>
        <p><strong>Type:</strong> <%= event.getTypeString() %></p>
        <p><strong>Description:</strong> <%= event.getDescription() %></p>
    </div>
</div>

</body>
</html>
