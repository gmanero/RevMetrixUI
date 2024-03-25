<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Registration</title>
    <link rel = "stylesheet" type ="text/css" href="CSS/registrationStyles.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#eventDate").datepicker();
        });
    </script>
</head>

<body>

            <jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>Register</h1>
       </div>
       
    <form action="registrationServlet" method="post">
        <div class="container">
            <h2>Register for an Event</h2>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword">
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" id="age" name="age">
            </div>
            <div class="form-group">
                <label for="eventId">Event ID:</label>
                <input type="text" id="eventId" name="eventId">
            </div>
            <div class="form-group">
                <label for="eventDate">Event Date:</label>
                <input type="text" id="eventDate" name="eventDate" >
            </div>
            <input type="submit" value="Register">
        </div>
      </form>

</body>

</html>
