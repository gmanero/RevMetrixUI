<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Stats</title>
    <link rel = "stylesheet" type ="text/css" href="CSS/statsStyles.css">
</head>

<body>
 <jsp:include page="navbar.jsp" />
    <div class="topPage">
        <h1>Take a look at stats</h1>
    </div>

    <div class="infoSection">
        <h3>Game Stats:</h3>
        <ul>
            <li><span class="highlight">Average frame score:</span> ${stats.avgFrameScore}</li>
            <li><span class="highlight">Strike percentage:</span> ${stats.strikePer}</li>
            <li><span class="highlight">Spare percentage:</span> ${stats.sparePer}</li>
            <li><span class="highlight">Number of open frames:</span> ${stats.openFrame}</li>
          
        </ul>
    </div>
</body>
</html>
