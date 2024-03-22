<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bowling Events</title>
    <link rel = "stylesheet" type ="text/css" href="CSS/eventStyles.css">
</head>

<body>
    <div class="topPage">
        <h1>Bowling Events</h1>
    </div>

              <form method= "get">
    <div class="links">
        <button type="submit" name="destination" value="revMetrix" class="button">RevMetrix</button>
        <button type="submit" name="destination" value="events" class="button">Events</button>
        <button type="submit" name="destination" value="register" class="button">Register</button>
        <button type="submit" name="destination" value="stats" class="button">Stats</button>
        <button type="submit" name="destination" value="game" class="button">Your Game</button>
         <button type="submit" name="destination" value="login" class="button">Login</button>
          <button type="submit" name="destination" value="account" class="button">Account</button>
    </div>
     </form>


    <!-- Tournaments Section -->
    <div class="section">
        <div class="section-title">Featured Tournaments</div>
        <div class="tournaments">
            <div class="tournament" onclick="location.href='https://example.com/tournament1';">
                <h2>Tournament 1</h2>
                <p><strong>Date:</strong> January 15, 2025</p>
                <p><strong>Location:</strong> Bowling Palace, 123 Main St, Cityville</p>
                <p>A friendly tournament for amateur bowlers. Come and showcase your skills!</p>
            </div>
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
            <!-- Add more tournaments here -->
        </div>
    </div>

 <!-- Tournaments Section -->
    <div class="section">
        <div class="section-title">Featured Leagues</div>
        <div class="tournaments">
            <div class="tournament" onclick="location.href='https://example.com/tournament1';">
                <h2>League 1 </h2>
                
                <p><strong>Location:</strong> Bowling Palace, 123 Main St, Cityville</p>
                <p>A friendly tournament for amateur bowlers. Come and showcase your skills!</p>
            </div>
            <div class="tournament" onclick="location.href='https://example.com/tournament2';">
                <h2>League 2</h2>
                
                <p><strong>Location:</strong> Thunder Lanes, 456 Oak Ave, Townsville</p>
                <p>An exciting competition with cash prizes for winners. Register now!</p>
            </div>
            <div class="tournament" onclick="location.href='https://example.com/tournament3';">
                <h2>League 3</h2>
               
                <p><strong>Location:</strong> Strike Zone, 789 Elm St, Villageton</p>
                <p>A charity tournament to support local causes. Join us for a fun-filled day!</p>
            </div>
            <!-- Add more tournaments here -->
        </div>
    </div>

    <!-- Practice Sessions Section -->
    <div class="section">
        <div class="section-title">Featured Practice Sessions</div>
        <div class="section-content">
            <p>Hone your skills with our featured practice sessions:</p>
            <ul>
                <li><strong>Session 1:</strong> Date: January 10, 2025 | Location: Lane Master, 789 Oak St, Bowlingtown</li>
                <li><strong>Session 2:</strong> Date: February 5, 2025 | Location: Pin City, 456 Elm St, Alleyville</li>
                <li><strong>Session 3:</strong> Date: March 20, 2025 | Location: Roll & Bowl, 123 Maple Ave, Bowlertown</li>
            </ul>
        </div>
    </div>
    
     <div class="section-title">Upcoming Events</div>
        <div class="section-content">
            <p>This section displays upcoming events.</p>
        </div>
   

</body>

</html>
