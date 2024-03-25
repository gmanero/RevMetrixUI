<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix</title>
    <link rel="stylesheet" type="text/css" href="CSS/navbarStyles.css">
</head>
<body>

<div class="navbar">
    <div class="logo">
        <form method="get">
            <button type="submit" name="destination" value="revMetrix" class="nav-item"><img class="logo" src="images/RevMetrixUI_Logo.png"  alt="Logo"></button>
        </form>
    </div>
    <div class="links">
        <form method="get">
            <div class="dropdown">
                <button type="submit" class="nav-item dropbtn" name="destination" value="event">Events</button>
                <div class="dropdown-content">
                    <button type="submit" name="destination" value="tournaments" class="nav-dropdown">Tournaments</button>
                    <button type="submit" name="destination" value="practices" class="nav-dropdown">Practices</button>
                    <button type="submit" name="destination" value="leagues" class="nav-dropdown">Leagues</button>
                </div>
            </div>
            
            <div class="dropdown">
                <button type="submit" class="nav-item dropbtn" name="destination" value="create">Create</button>
                <div class="dropdown-content">
                    <button type="submit" name="destination" value="createTournament" class="nav-dropdown">Create Tournament</button>
                    <button type="submit" name="destination" value="createPractice" class="nav-dropdown">Create Practice</button>
                    <button type="submit" name="destination" value="createLeague" class="nav-dropdown">Create League</button>
                </div>
            </div>
            
            <button type="submit" name="destination" value="stats" class="nav-item">Stats</button>
            <button type="submit" name="destination" value="yourGames" class="nav-item">Your Games</button>
            <button type="submit" name="destination" value="game" class="nav-item">Quick Bowl</button>
        </form>
    </div>
    <div class="login">
        <form method="get">
            <button type="submit" name="destination" value="login" class="login-btn">Login</button>
            <button type="submit" name="destination" value="account" class="account-btn">Account</button>
        </form>
    </div>
</div>

</body>
</html>
