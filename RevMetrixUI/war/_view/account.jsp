
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

<div class="bowlingBalls" id="bowlingBalls">
    <!-- Hardcoded Bowling Balls -->
    <div class="bowlingBall" data-name="Ball 1" data-weight="12" data-color="red">Ball</div>

    <!-- Add Ball Button -->
    <div class="addBall">
        <span class="plus">+</span>
    </div>
</div>

<div class="addBallForm" id="addBallForm">
    <h2>Add a New Bowling Ball</h2>
    <form>
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
    const bowlingBalls = document.getElementById('bowlingBalls');
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
        ball.dataset.name = name;
        ball.dataset.weight = weight;
        ball.dataset.color = color;
        ball.textContent = name;
        ball.style.backgroundColor = color;
        bowlingBalls.insertBefore(ball, addBallButton);
    }
});
</script>
</body>
</html>
