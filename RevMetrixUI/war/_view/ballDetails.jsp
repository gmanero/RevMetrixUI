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
    
        <div class="ball" id="movingBall"></div>
        <div class="ball-info">
            <div class="ball-container">
                <% 
                    int ballId = Integer.parseInt(request.getParameter("id"));
                    AllAccountsController controller = new AllAccountsController();
                    List<Ball> balls = controller.findBallById(ballId);
                    if (balls != null && !balls.isEmpty()) {
                        for (Ball ball : balls) {
                %>
                <style>
                    .ball {
                        background-color: <%= ball.getColor() %>;
                    }
                </style>
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

        <div class="stats-table">
            <table>
                <tr>
                    <th colspan="2">Ball Details</th>
                </tr>
                <% 
                    if (balls != null && !balls.isEmpty()) {
                        for (Ball ball : balls) {
                %>
                <tr>
                    <td>Name:</td>
                    <td><%= ball.getName() %></td>
                </tr>
                <tr>
                    <td>Weight:</td>
                    <td><%= ball.getWeight() %> lbs</td>
                </tr>
                <tr>
                    <td>Color:</td>
                    <td><%= ball.getColor() %></td>
                </tr>
                <% 
                        }
                    } 
                %>
            </table>
        </div>

        <div class="stats-table">
            <table>
                <tr>
                    <th>Stats</th>
                    <th>Values</th>
                </tr>
                <tr>
                    <td>Total Shots</td>
                    <td><%= controller.getTotalShotsForBall(ballId) %></td>
                </tr>
                <tr>
                    <td>Total Spares</td>
                    <td><%= controller.getTotalSparesForBall(ballId) %></td>
                </tr>
                <tr>
                    <td>Total Strikes</td>
                    <td><%= controller.getTotalStrikesForBall(ballId) %></td>
                </tr>
                <tr>
                    <td>Total Fouls</td>
                    <td><%= controller.getTotalFoulsForBall(ballId) %></td>
                </tr>
                <tr>
                    <td>Total Misses</td>
                    <td><%= controller.getTotalMissesForBall(ballId) %></td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
