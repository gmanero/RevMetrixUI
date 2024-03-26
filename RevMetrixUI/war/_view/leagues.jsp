<!DOCTYPE html>
<html lang="en">

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
            <div class="tournament" onclick="location.href='https://example.com/league1';">
                <h2>League 1</h2>
                <p><strong>Location:</strong> Bowling Palace, 123 Main St, Cityville</p>
                <p>A friendly tournament for amateur bowlers. Come and showcase your skills!</p>
            </div>
            <div class="tournament" onclick="location.href='https://example.com/league2';">
                <h2>League 2</h2>
                <p><strong>Location:</strong> Thunder Lanes, 456 Oak Ave, Townsville</p>
                <p>An exciting competition with cash prizes for winners. Register now!</p>
            </div>
            <div class="tournament" onclick="location.href='https://example.com/league3';">
                <h2>League 3</h2>
                <p><strong>Location:</strong> Strike Zone, 789 Elm St, Villageton</p>
                <p>A charity tournament to support local causes. Join us for a fun-filled day!</p>
            </div>
            <!-- Add more leagues here -->
        </div>
    </div>

</body>

</html>
