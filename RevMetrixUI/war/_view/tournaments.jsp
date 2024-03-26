<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
            <div class="tournament" onclick="location.href='https://example.com/tournament2';">
                <h2>Tournament 2</h2>
                <p><strong>Date:</strong> June 20, 2024</p>
                <p><strong>Location:</strong> Thunder Lanes, 456 Oak Ave, Townsville</p>
                <p>An exciting competition with cash prizes for winners. Register now!</p>
            </div>
            <div class="tournament" onclick="location.href='https://example.com/tournament3';">
                <h2>Tournament 3</h2>
                <p><strong>Date:</strong> March 30, 2024</p>
                <p><strong>Location:</strong> Strike Zone, 789 Elm St, Villageton</p>
                <p>A charity tournament to support local causes. Join us for a fun-filled day!</p>
            </div>
                <c:forEach var="tournaments" items="${tournaments}">
		            <div class="tournament">
		                <h2>${tournaments.tournamentName}</h2>
		                <p><strong>Date:</strong> ${tournaments.tournamentStartDate.toString()}</p>
		                <p><strong>Location:</strong> ${tournaments.tournamentLocation}</p>
		                <p><strong>Description:</strong> ${tournaments.tournamentDescription}</p>
		                <p><strong>Capacity:</strong> ${tournaments.tournamentCapacity}</p>
		            </div>
        		</c:forEach>
            </div>
            <!-- Add more tournaments here -->
        </div>

</body>

</html>