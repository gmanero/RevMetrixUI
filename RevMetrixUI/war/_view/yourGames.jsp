<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Your Games</title>
    <link rel="stylesheet" type="text/css" href="CSS/yourGamesStyles.css">
</head>

<body>

    <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Your Games</h1>
    </div>

    <!-- Your Tournaments Section -->
    <div class="section">
        <div class="section-title">Your Tournaments</div>
        <div class="tournaments">
            <div class="tournament" onclick="location.href='https://example.com/tournament1';">
                <h2>Tournament</h2>
                <p><strong>Date:</strong> January 15, 2025</p>
                <p><strong>Location:</strong> Bowling Palace, 123 Main St, Cityville</p>
                <p>A friendly tournament for amateur bowlers. Come and showcase your skills!</p>
            </div>
        </div>
    </div>

    <!-- Your Leagues Section -->
    <div class="section">
        <div class="section-title">Your Leagues</div>
        <div class="tournaments">
            <div class="tournament" onclick="location.href='https://example.com/league1';">
                <h2>League</h2>
                <p><strong>Location:</strong> Bowling Palace, 123 Main St, Cityville</p>
                <p>A friendly league for amateur bowlers. Join us and have fun!</p>
            </div>
        </div>
    </div>

    <!-- Your Practice Sessions Section -->
    <div class="section">
        <div class="section-title">Your Practice Sessions</div>
        <div class="section-content">
            <p>Hone your skills with our featured practice sessions:</p>
            <ul>
                <li><strong>Session:</strong> Date: January 10, 2025 | Location: Lane Master, 789 Oak St, Bowlingtown</li>
            </ul>
        </div>
    </div>

    <!-- Upcoming Events Section -->
    <div class="section">
        <div class="section-title">Upcoming Events</div>
        <div class="section-content">
            <p>This section displays upcoming events.</p>
        </div>
    </div>

</body>

</html>
