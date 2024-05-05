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
    
    // Retrieve all bowling balls
    List<Ball> balls = controller.findAllBalls();
%>




<div class="pageTitle"><h2>Bowling Ball's</h2></div>
         

<div class="bowlingBalls" id="bowlingBalls">
    <% if (balls != null && !balls.isEmpty()) { %>
        <% for (Ball ball : balls) { %>
            <div class="bowlingBall" style="background-color: <%= ball.getColor() %>;">
                <p><%= ball.getName() %></p>
            </div>
        <% } %>
    <% } else { %>
        <p>No bowling balls found.</p>
    <% } %>
    <button class="addBall">+</button>
    <div class="addBallForm" id="addBallForm">
        <h3>Add Ball Form</h3>
        <form action="addBall" method="post">
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
    addBallForm.querySelector('form').addEventListener('submit', function(event) {
        event.preventDefault();

        const nameInput = addBallForm.querySelector('#name');
        const weightInput = addBallForm.querySelector('#weight');
        const colorInput = addBallForm.querySelector('#color');

        const name = nameInput.value;
        const weight = weightInput.value;
        const color = colorInput.value;

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
            <p>${name}</p>
        `;
        const bowlingBalls = document.getElementById('bowlingBalls');
        bowlingBalls.insertBefore(ball, addBallForm);
    }
});
</script>

</body>
</html>
