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
        
            <div class="tournament" onclick ="redirectToRegistration('registration');">
                <h2>Tournament 1</h2>
                <p><strong>Date:</strong>03/27/2024</p>
                <p><strong>Location:</strong> Thunder Lanes, 456 Oak Ave, Townsville</p>
                <p><strong>Description:</strong>Only for RevmMetrix players, competitive tournament</p>
                <p><strong>Capacity:</strong> 20</p>
            </div>
       
            <div class="tournament" onclick ="redirectToRegistration('registration');" >
                <h2>Tournament 2</h2>
                <p><strong>Date:</strong> 03/28/2024</p>
                <p><strong>Location:</strong> Strike Zone, 789 Elm St, Villageton</p>
                <p><strong>Description:</strong>Competitive tournament for friends and family to join!</p>
                <p><strong>Capacity:</strong>10</p>
            </div>
                <c:forEach var="tournaments" items="${tournaments}">
		            <div class="tournament" onclick = "redirectToRegistration('registration');">
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
<script>
        function redirectToRegistration(url) {
            
            window.location.href = url;
        }
    </script>
</body>

</html>