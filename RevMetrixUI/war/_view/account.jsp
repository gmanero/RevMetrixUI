<%@ page import="java.util.List" %>
<%@ page import="revMetrix.db.model.Account" %>
<%@ page import="revMetrix.db.model.Ball" %>
<%@ page import="revMetrix.controller.AllAccountsController" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Account</title>
    <link rel="stylesheet" type="text/css" href="CSS/accountStyles.css">
</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="topPage">
    <h1>Account</h1>
</div>

<div class="mainText">
    <p>Welcome to your account page! Here you can manage your profile, view your bowling balls collection, and more.</p>
</div>

<%
    // Create a new instance of AllAccountsController
    AllAccountsController controller = new AllAccountsController();
    
    // Retrieve all accounts
    List<Account> accounts = controller.getAllAccounts();
%>

<div class="accountSection">
    <h2>Your Accounts</h2>
    <% if (accounts != null && !accounts.isEmpty()) { %>
        <div class="accountCards">
            <% for (Account account : accounts) { %>
                <div class="accountCard">
                    <h3>Email: <%= account.getEmail() %></h3>
                    <p>Password: <%= account.getPassword() %></p>
                    <p>First Name: <%= account.getFirstname() %></p>
                    <p>Last Name: <%= account.getLastname() %></p>
                    <p>Logged In: <%= account.isLoggedIn() %></p>
                </div>
            <% } %>
        </div>
    <% } else { %>
        <p>No accounts found.</p>
    <% } %>
</div>

<%
    // Retrieve all bowling balls
    List<Ball> balls = controller.findAllBalls();
%>

<div class="bowlingBalls" id="bowlingBalls">
    <h2>Your Bowling Balls</h2>
    <% if (balls != null && !balls.isEmpty()) { %>
        <% for (Ball ball : balls) { %>
            <div class="bowlingBall" style="background-color: <%= ball.getColor() %>;">
                <p>Name: <%= ball.getName() %></p>
                <p>Weight: <%= ball.getWeight() %> lbs</p>
                <p>Color: <%= ball.getColor() %></p>
            </div>
        <% } %>
    <% } else { %>
        <p>No bowling balls found.</p>
    <% } %>
    <h2>Add a New Bowling Ball</h2>
    <form action="account" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="weight">Weight (lbs):</label>
        <input type="number" id="weight" name="weight" min="10" max="16" required>
        <br>
        <label for="color">Color:</label>
        <input type="text" id="color" name="color" required>
        <br>
        <button type="submit">Add Ball</button>
    </form>
</div>

<script>
document.addEventListener('DOMContentLoaded', function() {
    const addBallButton = document.querySelector('.addBall');
    const addBallForm = document.getElementById('addBallForm');

    // Display or hide add ball form
    addBallButton.addEventListener('click', function() {
        addBallForm.classList.toggle('show');
    });

    // Add ball form submission
    addBallForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const name = document.getElementById('name').value;
        const weight = document.getElementById('weight').value;
        const color = document.getElementById('color').value;

        if (name && weight && color) {
            addBowlingBall(name, weight, color);
            addBallForm.classList.remove('show');
            addBallForm.reset();
        } else {
            alert('Please enter name, weight, and color.');
        }
    });

    // Function to add a new bowling ball
    function addBowlingBall(name, weight, color) {
        const ball = document.createElement('div');
        ball.classList.add('bowlingBall');
        ball.style.backgroundColor = color;
        ball.innerHTML = `
            <p>Name: ${name}</p>
            <p>Weight: ${weight} lbs</p>
            <p>Color: ${color}</p>
        `;
        const bowlingBalls = document.getElementById('bowlingBalls');
        bowlingBalls.appendChild(ball);
    }
});
</script>

</body>
</html>
