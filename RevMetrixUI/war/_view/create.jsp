<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create</title>
    <link rel="stylesheet" type="text/css" href="CSS/createStyles.css">
</head>

<body>

    <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Create</h1>
    </div>


 <form method="get">
    <div class="container">
   
        <div class="box">
            <h2>Create Practice</h2>
            <p>Create a new practice session for your team. Enter details such as practice name, date, location, and description.</p>
             <button type="submit" name="destination" value="createPractice" class="button">Create Practice</button>
        </div>
        <div class="box">
            <h2>Create Tournament</h2>
            <p>Create a new tournament event. Specify the tournament name, start date, location, and other relevant details.</p>
            <button type="submit" name="destination" value="createTournament" class="button">Create Tournament</button>
        </div>
        <div class="box">
            <h2>Create League</h2>
            <p>Create a new league for ongoing competitions. Define the league name, start date, location, and additional information.</p>
            <button type="submit" name="destination" value="createLeague" class="button">Create League</button>
        </div>
       
    </div>
     </form>

</body>

</html>
