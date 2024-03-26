<%@ page import="java.util.ArrayList" %>
<%@ page import="revMetrix.model.RevMetrix.Tournament" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Bowling Events</title>
    <link rel="stylesheet" type="text/css" href="CSS/tournamentsStyles.css">
</head>

<body>

    <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Bowling Events</h1>
    </div>

    <!-- Tournaments Section -->
    <div class="section">
        <div class="section-title">Featured Tournaments</div>
        <div class="tournaments">
            <% 
                ArrayList<Tournament> tournaments = (ArrayList<Tournament>) request.getAttribute("tournaments");
                if (tournaments != null){
                    for (Tournament tournament : tournaments) { 
            %>
            <div class="tournament" onclick="location.href='https://example.com/tournament<%=tournament.getTournamentId()%>';">
                <h2><%=tournament.getTournamentName()%></h2>
                <p><strong>Date:</strong> <%=tournament.getTournamentStartDate()%></p>
                <p><strong>Location:</strong> <%=tournament.getTournamentLocation()%></p>
                <p><%=tournament.getTournamentDescription()%></p>
            </div>
            <%
                 } 
                } else{
                    out.println("No tournaments available");

                }
        %>
        </div>
    </div>

</body>

</html>
