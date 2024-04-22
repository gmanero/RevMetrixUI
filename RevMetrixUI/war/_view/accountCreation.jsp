<!DOCTYPE html>
<html lang="en">
<head>
    <title>Account</title>    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/accountCreationStyles.css">
    
    <script>
        function validateForm() {
            var email = document.getElementById("email").value;
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var password2 = document.getElementById("password2").value;

            if (email === "" || username === "" || password === "" || password2 === "") {
                alert("All fields are required");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<jsp:include page="navbar.jsp" />

    <div class="topPage">
        <h1>RevMetrix - Create an Account</h1>
    </div>
    
  <form class="loginForm" action="${pageContext.servletContext.contextPath}/accountCreation" method="post">

    <h1>Sign Up</h1>

        <p>Enter your Email Address</p>
    <input type="text" id="email" name="email" placeholder="Email">

    <p>Enter your First Name</p>
    <input type="text" id="firstname" name="firstname" placeholder="First Name">
    <p>Enter your Last Name</p>
    <input type="text" id="lastname" name="lastname" placeholder="Last Name">

    <p>Enter your Password</p>
    <input type="password" id="password" name="password" placeholder="Password">

    <p>Confirm your Password</p>
    <input type="password" id="password2" name="password2" placeholder="Password"><br><br>

    <button type="submit" class="signUpBtn" onclick="submitForm()">Sign Up</button>
    
    
    <div class="linkToAccount">
    <button type="submit" class="linkToAccount" name="destination" value="login" >Already have a login?</button>
</div>

</form>


    

</body>
</html>
