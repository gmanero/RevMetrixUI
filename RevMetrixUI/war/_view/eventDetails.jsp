<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="revMetrix.db.model.Event" %>
<%@ page import="revMetrix.db.model.Session" %>
<%@ page import="revMetrix.db.model.Game" %>
<%@ page import="revMetrix.controller.EventController" %>
<%@ page import="revMetrix.controller.GameController" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Details</title>
    <link rel="stylesheet" type="text/css" href="CSS/eventDetailsStyles.css">
</head>

<body>
    <%@ include file="navbar.jsp" %>

    <div class="topPage">
        <h1>Event Details:</h1>
    </div>

    <div class="container">
        <div class="event-box">
            <% 
                // Get the event ID from the request parameter
                int eventId = Integer.parseInt(request.getParameter("id"));

                // Retrieve event details from the controller
                EventController eventController = new EventController();
                GameController gameController = new GameController();
                List<Event> event = eventController.findEventByID(eventId);

                // Check if event details exist
                if (event != null && !event.isEmpty()) {
                    // Display event details
                    for (Event e : event) {
            %>
            <div class="event-box">
                <h3><%= e.getName() %></h3>
                <p><strong>Establishment:</strong> <%= e.getEstablishmentName() %></p>
                <p><strong>Type:</strong> <%= e.getTypeString() %></p>
                <p><strong>Description:</strong> <%= e.getDescription() %></p>
                <p><strong>Start Date:</strong> <%= e.getStartdate() %><p>
            </div>
            <% if (!e.isDone()) { %>
            <div class="event-box">
            <form action="${pageContext.servletContext.contextPath}/eventDetails" method = "post">
            <button class="Archive">Archive</button>
    		<input type = "hidden" class="add" type="number" name = "add" value = "Archive" >
    		<input type = "hidden" name = "eventId" value = "<%= eventId %>">
    		
    		</form>
            <form action="${pageContext.servletContext.contextPath}/eventDetails" method = "post">
            <button class="add-button">Add Sessions</button>
    		<input class="add" type="number" name = "add" value = "" min="1"  max="15" >
    		<input type = "hidden" name = "eventId" value = "<%= eventId %>">
    		
    		</form>
    		<% } %>
            </div>
            <% 
                    }
                } else {
            %>
            <p>No event details found.</p>
            <% 
                }
            %>
        </div>

        <div class="session-details">
            <h2>Session Details</h2>
            <% 
                // Retrieve sessions associated with the event ID
                List<Session> sessions = eventController.getSessionsByEvent(eventId);
				int i = 0;
                // Check if sessions exist for the event
                if (sessions != null && !sessions.isEmpty()) {
                    // Iterate over sessions and display details
                    for (Session s : sessions) {
                    	i++;
            %>
           <div class="session-box">
                    <div class="session-details">
                        <h3>Session <%= i %></h3>
                        <p class="score">Score: <%= s.getSessionScore() %></p>
                    </div>
           <br>
              <% 
              ArrayList<Game> games = gameController.GetGamesBySession(s.getSessionId());
              int j = 0;
              for (Game g: games){
            	  j++;
              %>
              <p class="score">	Game<%=i %>:  <%= g.getGameScore() %></p>
              <%} %>
              <% if (!event.get(0).isDone()) { %>
                    <form action="${pageContext.servletContext.contextPath}/game" method="get">
                        <input type="hidden" name="SesionID" value="<%= s.getSessionId() %>">
                        <button class="play-button">Play</button>
                    </form>
                    <form action="${pageContext.servletContext.contextPath}/eventDetails" method="post">
                        <input type="hidden" name="remove" value="<%= s.getSessionId() %>">
                      <button class="remove-button">&times;</button>

                    </form>
                    <%} %>
                </div>
                <% 
                        }
                    } else {
                %>
                <p>No sessions found for this event.</p>
                <% 
                    }
                %>
            </div>
             </div>
</body>

</html>
