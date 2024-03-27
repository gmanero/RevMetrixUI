<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Bowling Events</title>
    <link rel="stylesheet" type="text/css" href="CSS/practicesStyles.css">
</head>

<body>

    <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Bowling Events</h1>
    </div>

    <!-- Practice Sessions Section -->
    <div class="section">
        <div class="section-title">Featured Practice Sessions</div>
        <div class="tournaments">
        
            <div class="tournament" onclick="redirectToRegistration('registration');">
                <h2>Practice Session 1</h2>
                <p><strong>Date:</strong>03/27/2024</p>
                <p><strong>Location:</strong> Lane Master, 789 Oak St, Bowlingtown</p>
                <p><strong>Description:</strong>Only for RevMetrix players, competitive tournament</p>
                <p><strong>Capacity:</strong> 20</p>
            </div>

            <div class="tournament" onclick="redirectToRegistration('registration');">
                <h2>Practice Session 2</h2>
                <p><strong>Date:</strong> 03/28/2024</p>
                <p><strong>Location:</strong> Pin City, 456 Elm St, Alleyville</p>
                <p><strong>Description:</strong> Competitive tournament for friends and family to join!</p>
                <p><strong>Capacity:</strong>10</p>
            </div>
            
            <c:forEach var="practices" items="${practices}">
                <div class="tournament" onclick="redirectToRegistration('registration');">
                    <h2>${practices.practiceName}</h2>
                    <p><strong>Date:</strong> ${practices.practiceStartDate.toString()}</p>
                    <p><strong>Location:</strong> ${practices.practiceLocation}</p>
                    <p><strong>Description:</strong> ${practices.practiceDescription}</p>
                    <p><strong>Capacity:</strong> ${practices.practiceCapacity}</p>
                </div>
            </c:forEach>
        </div>
        <!-- Add more tournaments here -->
    </div>

    <script>
        function redirectToRegistration(url) {
            // Redirect to the registration page
            window.location.href = url;
        }
    </script>

</body>

</html>
