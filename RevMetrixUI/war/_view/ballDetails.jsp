<%@ page import="java.util.List" %>
<%@ page import="revMetrix.db.model.Ball" %>
<%@ page import="revMetrix.controller.AllAccountsController" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ball Details</title>
    <link rel="stylesheet" type="text/css" href="CSS/ballDetailsStyles.css">
</head>

<body>
    <%@ include file="navbar.jsp" %>

    <div class="topPage">
        <h1>Ball Details</h1>
    </div>

    <div class="container">
        <div class="ball-box">
            <% 
                // Get the ball ID from the request parameter
                int ballId = Integer.parseInt(request.getParameter("id"));

                // Retrieve ball details from the controller
                AllAccountsController controller = new AllAccountsController();
                List<Ball> balls = controller.findBallById(ballId);

                // Check if ball details exist
                if (balls != null && !balls.isEmpty()) {
                    // Display ball details
                    for (Ball ball : balls) {
            %>
            <div class="ball-details">
                <h3><%= ball.getName() %></h3>
                <p><strong>Weight:</strong> <%= ball.getWeight() %> lbs</p>
                <p><strong>Color:</strong> <%= ball.getColor() %></p>
            </div>
            <% 
                    }
                } else {
            %>
            <p>No ball details found.</p>
            <% 
                }
            %>
        </div>
    </div>
</body>

</html>
