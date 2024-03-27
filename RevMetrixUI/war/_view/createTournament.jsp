<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Tournament</title>
    <link rel="stylesheet" type="text/css" href="CSS/createTournamentStyles.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#tournamentStartDate").datepicker();
        });

        // Function to check if all fields are filled
        function validateForm() {
            var tournamentName = $("#tournamentName").val();
            var tournamentStartDate = $("#tournamentStartDate").val();
            var tournamentLocation = $("#tournamentLocation").val();
            var tournamentDescription = $("#tournamentDescription").val();
            var tournamentCapacity = $("#tournamentCapacity").val();

            // Check if any field is empty
            if (tournamentName == '' || tournamentStartDate == '' || tournamentLocation == '' || tournamentDescription == '' || tournamentCapacity == '') {
                alert("All fields are required!");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>

    <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Create Tournament</h1>
    </div>

    <form action= "${pageContext.servletContext.contextPath}/tournaments" method="post" onsubmit="return validateForm()">
        <div class="container">
            <h2>Tournament Details</h2>
            <div class="form-group"> 
                <label for="tournamentName">Tournament Name:</label>
                <input type="text" id="tournamentName" name="tournamentName">
            </div>
            <div class="form-group">
                <label for="tournamentStartDate">Tournament Start Date:</label>
                <input type="text" id="tournamentStartDate" name="tournamentStartDate">
            </div>
            <div class="form-group">
                <label for="tournamentLocation">Tournament Location:</label>
                <input type="text" id="tournamentLocation" name="tournamentLocation">
            </div>
            <div class="form-group">
                <label for="tournamentDescription">Tournament Description:</label>
                <textarea id="tournamentDescription" name="tournamentDescription"></textarea>
            </div>
            <div class="form-group">
                <label for="tournamentCapacity">Tournament Capacity:</label>
                <input type="number" id="tournamentCapacity" name="tournamentCapacity">
            </div>
            <input type="submit" value="Create Tournament">
        </div>
    </form>

</body>

</html>
