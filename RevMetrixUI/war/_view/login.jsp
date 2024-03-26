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
    <form  onsubmit="return redirectIfCorrect()">
        <input type="text" id="username" name="username" placeholder="Username">
        <br>
        <input type="password" id="password" name="password" placeholder="Password">
        <br>
       <input type="submit" value="Sign In">
       
       </form>
       
       <br/>
       
       <form method="get">
       <button type= "submit" name = "destination" value = "accountCreation" class="signUp">Sign Up</button>
    </form>
    </div>
    
    
    
    <script>
        function redirectIfCorrect() {
            var User = document.getElementById('correctUser').value;
            var Pass = document.getElementById('correctPass').value;
            
            var correctUser = "correctUser";
            var correctPass = "correctPass";
            
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
