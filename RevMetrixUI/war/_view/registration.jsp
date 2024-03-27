<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Registration</title>
    <link rel="stylesheet" type="text/css" href="CSS/registrationStyles.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#eventDate").datepicker();
        });

        // Function to check if all fields are filled
        function validateForm() {
            var username = $("#username").val();
            var email = $("#email").val();
            var password = $("#password").val();
            var confirmPassword = $("#confirmPassword").val();
            var age = $("#age").val();
            var eventId = $("#eventId").val();
            var eventDate = $("#eventDate").val();

            // Check if any field is empty
            if (username == '' || email == '' || password == '' || confirmPassword == '' || age == '' || eventId == '' || eventDate == '') {
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
        <h1>Register</h1>
    </div>

    <form method="post" onsubmit="return validateForm()"onsubmit = "redirectToRegistration('index');">
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
                <input type="text" id="eventDate" name="eventDate">
            </div>
            <input type="submit" value="Register">
        </div>
    </form>
<script>
        function redirectToRegistration(url) {
            // Redirect to the registration page
            window.location.href = url;
        }
    </script>
</body>

</html>
