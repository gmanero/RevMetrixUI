<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create League</title>
    <link rel="stylesheet" type="text/css" href="CSS/createLeagueStyles.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#leagueStartDate").datepicker();
        });
    </script>
</head>

<body>

    <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Create League</h1>
    </div>

    <form action="createLeagueServlet" method="post">
        <div class="container">
            <h2>League Details</h2>
            <div class="form-group">
                <label for="leagueName">League Name:</label>
                <input type="text" id="leagueName" name="leagueName">
            </div>
            <div class="form-group">
                <label for="leagueStartDate">League Start Date:</label>
                <input type="text" id="leagueStartDate" name="leagueStartDate">
            </div>
            <div class="form-group">
                <label for="leagueLocation">League Location:</label>
                <input type="text" id="leagueLocation" name="leagueLocation">
            </div>
            <div class="form-group">
                <label for="leagueDescription">League Description:</label>
                <textarea id="leagueDescription" name="leagueDescription"></textarea>
            </div>
            <div class="form-group">
                <label for="leagueCapacity">League Capacity:</label>
                <input type="number" id="leagueCapacity" name="leagueCapacity">
            </div>
            <input type="submit" value="Create League">
        </div>
    </form>

</body>

</html>
