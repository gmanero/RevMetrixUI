<!DOCTYPE html>
<html lang="en">
<head>
    <title>Account</title>    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   	<link rel = "stylesheet" type ="text/css" href="CSS/accountCreationStyles.css">
</head>

<body>
<jsp:include page="navbar.jsp" />
    <div class="topPage">
        <h1>RevMetrix - Create an Account</h1>
    </div>
    
    <!-- accountCreation form -->
        <form class="loginForm">
        <h1>Register</h1>

        <p>Enter your Email Address</p>                  
            <input type="text" id="email" name="email" placeholder="Email">

        <p>Enter your Username</p>                  
            <input type="text" id="usename" name="username" placeholder="Username">

        <p>Enter your Password</p>     
            <input type="text" id="password" name="password" placeholder="Password">

        <p>Retype your Password</p>     
            <input type="text" id="password2" name="password2" placeholder="Password"><br><br>

            <input type="submit" value="Sign Up">

            <div class="linkToAccount">
                <a href="location.href='http://localhost:8081/revMetrix/index?destination=login">Already have an login?</a>
            </div>
            
    </form>
    
    
  

</body>
</html>
