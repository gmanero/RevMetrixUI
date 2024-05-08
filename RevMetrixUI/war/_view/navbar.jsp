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
            <button type="submit" name="destination" value="RevMetrix" class="nav-item"><img class="logo" src="images/RevMetrixUI_Logo.png"  alt="Logo"></button>
        </form>
    </div>
    <div class="links">
        <form action="${pageContext.servletContext.contextPath}/index" method="get">
            <div class="dropdown">
                <button type="submit" class="nav-item dropbtn" name="destination" value="event">Events</button>
                <div class="dropdown-content">
                    <button type="submit" name="destination" value="tournaments" class="nav-dropdown">Tournaments</button>
                    <button type="submit" name="destination" value="practices" class="nav-dropdown">Practices</button>
                    <button type="submit" name="destination" value="leagues" class="nav-dropdown">Leagues</button>
                </div>
            </div>
            
            <button type="submit" class="nav-item dropbtn" name="destination" value="create">Create</button>

            <div class="dropdown">
                <button type="submit" class="nav-item dropbtn" name="destination" value="stats">Stats</button>
                <div class="dropdown-content">
                    <button type="button" class="nav-dropdown" onclick="window.location.href='leagueSheet'">League Sheet</button>
                </div>
            </div>
            
            <button type="submit" name="destination" value="Archive" class="nav-item">Event Archive</button>
            <button type="submit" name="destination" value="game" class="nav-item">Quick Bowl</button>
        </form>
    </div>
    
     <div class="login">
        <form action="${pageContext.servletContext.contextPath}/index" method="get">
            <% Boolean loggedIn = (Boolean) request.getAttribute("loggedIn"); %>
            <% if (loggedIn != null && loggedIn) { %>
                <div class="left"><span class="loggedInName"><p>Hello, ${loggedInName}</p></span></div>
                <div class="center"><button type="submit" name="destination" value="logout" class="login-btn">Logout</button></div>
            <% } else { %>
                <div class="center"><button type="submit" name="destination" value="login" class="login-btn">Login</button></div>
            <% } %>
            <div class="right"><button type="submit" name="destination" value="account" class="account-btn">Account</button></div>
        </form>
    </div>
</div>

</body>
</html>
