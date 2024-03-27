<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Bowling Events</title>
    <link rel="stylesheet" type="text/css" href="CSS/leaguesStyles.css">
</head>

<body>

    <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Bowling Events</h1>
    </div>

    <!-- Leagues Section -->
    <div class="section">
        <div class="section-title">Featured Leagues</div>
        <div class="tournaments">
        
            <div class="tournament" onclick = "redirectToRegistration('registration');">
                <h2>League 1</h2>
                <p><strong>Date:</strong> 03/27/24</p>
                <p><strong>Location:</strong> Bowling Palace, 123 Main St, Cityville</p>
                <p><strong>Description:</strong>Only for RevmMetrix players, competitive tournament</p>
                <p><strong>Capacity:</strong> 20</p>
            </div>
            <div class="tournament" onclick = "redirectToRegistration('registration');">
                <h2>League 2</h2>
                <p><strong>Date:</strong> 03/28/24</p>
                <p><strong>Location:</strong> Thunder Lanes, 456 Oak Ave, Townsville</p>
                <p><strong>Description:</strong>Competitive tournament for friends and family to join!</p>
                <p><strong>Capacity:</strong> 20</p>
            </div>
               <c:forEach var="leagues" items="${leagues}">
		            <div class="tournament" onclick = "redirectToRegistration('registration');">
		                <h2>${leagues.leagueName}</h2>
		                <p><strong>Date:</strong> ${leagues.leagueStartDate.toString()}</p>
		                <p><strong>Location:</strong> ${leagues.leagueLocation}</p>
		                <p><strong>Description:</strong> ${leagues.leagueDescription}</p>
		                <p><strong>Capacity:</strong> ${leagues.leagueCapacity}</p>
		            </div>
        		</c:forEach>
            </div>
            <!-- Add more leagues here -->
        </div>
<script>
        function redirectToRegistration(url) {
            
            window.location.href = url;
        }
    </script>
</body>

</html>
