<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Log In</title>
   	<link rel = "stylesheet" type ="text/css" href="CSS/loginStyles.css">
</head>
<body>
    <div class="topPage">
        <h1>RevMetrix</h1>
    </div>

    <!-- Navigation Bar -->
    <div class="links">
        <button type="button" class="button">RevMetrix</button>
        <button type="button" class="button">Events</button>
        <button type="button" class="button">Register</button>
        <button type="button" class="button">Stats</button>
        <button type="button" class="button">Your Game</button>
        <button type="button" class="button">Login</button>
        <button type="button" class="button">Account</button>
    </div>

    <!-- Login Form -->
    <form class="loginForm" onsubmit="return redirectIfCorrect()">
        <input type="text" id="username" name="username" placeholder="Username">
        <br>
        <input type="password" id="password" name="password" placeholder="Password">
        <br>
       <input type="submit" value="Log In">
    </form>
    
    <script>
        function redirectIfCorrect() {
            var User = document.getElementById('username').value;
            var Pass = document.getElementById('password').value;
            
            var correctUser = "Don";
            var correctPass = "Hake";
            
            if (User === correctUser && Pass === correctPass) {
                window.location.href = "http://localhost:8081/revMetrix/index";
                return false; // Prevent form submission
            } else {
                alert("Incorrect Username or Password");
                return false; // Prevent form submission
            }
        }
    </script>
</body>
</html>
