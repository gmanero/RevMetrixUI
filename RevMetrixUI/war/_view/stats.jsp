<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Stats</title>
    <link rel="stylesheet" type="text/css" href="CSS/statsStyles.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="topPage">
        <h1>Take a look at stats</h1>
    </div>

    <form class="Stats" action="${pageContext.servletContext.contextPath}/stats" method="post">
        <div class="infoSection">
            <h3>Game Stats:</h3>
            <ul>
                <li><span class="highlight">Average game score:</span> <%= request.getAttribute("averageGameScore") %></li>
                <li><span class="highlight">Total Strike:</span> <%= request.getAttribute("strikesPerGame") %></li>
                <li><span class="highlight">Total Spare:</span> <%= request.getAttribute("sparesPerGame") %></li>
            </ul>
        </div>
    </form>
</body>
</html>