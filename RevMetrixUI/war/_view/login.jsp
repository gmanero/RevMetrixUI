<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Log In</title>
   	<link rel = "stylesheet" type ="text/css" href="CSS/loginStyles.css">
</head>
<body>

 <!-- Navigation Bar -->
    <jsp:include page="navbar.jsp" />
    <div class="topPage">
        <h1>RevMetrix</h1>
    </div>
    
    
    
    
    <!-- Login Form -->
    <div class="loginForm">
        <form action="login" method="post" class="loginForm">
            <h1>Log In</h1>
            <input type="email" id="username" name="username" placeholder="Email" required>
            <br>
            <input type="password" id="password" name="password" placeholder="Password" required>
            <br>
            <input type="submit" value="Log In">
            <button type="button" onclick="window.location.href='accountCreation'" class="signUp">Sign Up</button>
        </form>
    </div>
    
    
    
    
    
    <script>
		function redirectIfCorrect() {
            var User = document.getElementById('email').value;
            var Pass = document.getElementById('password').value;
            
            if (User.trim() === '' || Pass.trim() === '') {
                alert("Please fill in both email and password fields.");
                return false; // Prevent form submission
            }
            
            var correctUser = "Don";
            var correctPass = "Hake";
            var correctUser1 = "Charles";
            var correctPass1 = "12345";
            
            if ((User === correctUser && Pass === correctPass) || (User === correctUser1 && Pass === correctPass1) ) {
                window.location.href = "http://localhost:8081/revMetrix/account";
                return false; // Prevent form submission
            } else {
                alert("Incorrect Email or Password");
                return false; // Prevent form submission
            }
        }

    </script>
    
</body>
</html>
