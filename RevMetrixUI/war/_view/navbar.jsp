<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrixPage</title>
    <link rel="stylesheet" type="text/css" href="CSS/navbarStyles.css">
</head>
<body>

<div class="navbar">
    <div class="logo">
        <img class="logo" src="images/RevMetrixUI_Logo.png"  alt="Logo">
    </div>
    <div class="links">
        <form method="get">
            <button type="submit" name="destination" value="revMetrix" class="nav-item">RevMetrix</button>
            <div class="dropdown">
                <button type="submit" class="nav-item dropbtn" name="destination" value="event">Events</button>
                <div class="dropdown-content">
                    <a href="#">Tournaments</a>
                    <a href="#">Practices</a>
                    <a href="#">Leagues</a>
                </div>
            </div>
            <button type="submit" name="destination" value="register" class="nav-item">Register</button>
            <button type="submit" name="destination" value="stats" class="nav-item">Stats</button>
            <button type="submit" name="destination" value="game" class="nav-item">Your Game</button>
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
