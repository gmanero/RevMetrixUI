<%@ page import="java.util.List" %>
<%@ page import="revMetrix.db.model.Ball" %>
<%@ page import="revMetrix.db.model.Establishment" %>
<%@ page import="revMetrix.controller.AllAccountsController" %>
<%@ page import="revMetrix.controller.EstablishmentController" %>

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

<h1>Welcome, ${loggedInName}!</h1>

<div class="mainText">
    <p>Here you can manage your profile, view your bowling balls collection, establishments and more.</p>
</div>

<%
    // Create a new instance of AllAccountsController
    AllAccountsController controller = new AllAccountsController();
	EstablishmentController Econtroller = new EstablishmentController();
    
    // Retrieve all bowling balls
    List<Ball> balls = controller.findAllBalls();
    
   
%>
<div class="pageTitle">
    <span class="loggedInName"><h2>Your Establishments</h2></span>
    </div>
    <div>
    <hr>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Lanes</th>
        </tr>
        <%
        List<Establishment> establishments = Econtroller.getAllEstablishments();
            for (int i = 0; i < establishments.size(); i++) {
                Establishment establishment = establishments.get(i);
        %>
            <tr>
                <td>
                    <form action="${pageContext.request.contextPath}/account" method="post">
                        <input type="hidden" name="action" value="updateEstablishment">
                        <input type="hidden" name="establishmentId" value="<%= establishment.getEstablishmentId() %>">
                        <input type="hidden" name="fieldName" value="name">
                        <input type="text" name="newValue" value="<%= establishment.getName() %>" onchange="this.form.submit()">
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/account" method="post">
                        <input type="hidden" name="action" value="updateEstablishment">
                        <input type="hidden" name="establishmentId" value="<%= establishment.getEstablishmentId() %>">
                        <input type="hidden" name="fieldName" value="address">
                        <input type="text" name="newValue" value="<%= establishment.getAddress() %>" onchange="this.form.submit()">
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/account" method="post">
                        <input type="hidden" name="action" value="updateEstablishment">
                        <input type="hidden" name="establishmentId" value="<%= establishment.getEstablishmentId() %>">
                        <input type="hidden" name="fieldName" value="phoneNumber">
                        <input type="text" name="newValue" value="<%= establishment.getPhoneNumber() %>" onchange="this.form.submit()">
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/account" method="post">
                        <input type="hidden" name="action" value="updateEstablishment">
                        <input type="hidden" name="establishmentId" value="<%= establishment.getEstablishmentId() %>">
                        <input type="hidden" name="fieldName" value="lanes">
                        <input type="number" name="newValue" value="<%= establishment.getLanes() %>" onchange="this.form.submit()">
                    </form>
                </td>
            </tr>
        <% } %>
    </table>
</div>
<button class="addEstablishment">Add Establishment</button>
    <div class="addEstablishmentForm" id="addEstablishmentForm">
        <h3>New Establishment</h3>
    <form action="${pageContext.request.contextPath}/account" method="post">
        <input type="hidden" name="action" value="addEstablishment">
        <label for="establishmentName">Name:</label>
        <input type="text" id="establishmentName" name="establishmentName" required>
        <br>
        <label for="establishmentAddress">Address:</label>
        <input type="text" id="establishmentAddress" name="establishmentAddress" required>
        <br>
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required>
        <br>
        <label for="lanes">Lanes:</label>
        <input type="number" id="lanes" name="lanes" min="1" required>
        <br>
        <button type="submit">Submit</button>
    </form>
</div>


<form method="get">
    <% Boolean loggedIn = (Boolean) request.getAttribute("loggedIn"); %>
    <% if (loggedIn != null && loggedIn) { %>
        <div class="pageTitle"><span class="loggedInName"><h2>Your Bowling Arsenal</h2></span></div>
        <hr>
    <% } else { %>
            
    <% } %>
</form>

<div class="bowlingBalls" id="bowlingBalls">
    <% if (balls != null && !balls.isEmpty()) { %>
        <% for (Ball ball : balls) { %>
          <a href="index?destination=ballDetails&id=<%= ball.getBallId() %>">
                <div class="bowlingBall" style="background-color: <%= ball.getColor() %>;">
                   
                </div>
                 <p class="ball-name"><%= ball.getName() %></p>
            </a>
        <% } %>
    <% } else { %>
        <p>No bowling balls found.</p>
    <% } %>
    <button class="addBall">+</button>
    <div class="addBallForm" id="addBallForm">
        <h3>Add Ball</h3>
        <form action="${pageContext.request.contextPath}/account" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <br>
            <label for="weight">Weight (lbs):</label>
            <input type="number" id="weight" name="weight" min="10" max="16" required>
            <br>
            <label for="color">Color:</label>
            <input type="text" id="color" name="color" required>
            <br>
            <button type="submit">Submit</button>
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
});
</script>
<script>
document.addEventListener('DOMContentLoaded', function() {
    const addEstablishmentButton = document.querySelector('.addEstablishment');
    const addEstablishmentForm = document.getElementById('addEstablishmentForm');

    // Display or hide add ball form
    addEstablishmentButton.addEventListener('click', function() {
        addEstablishmentForm.classList.toggle('show');
    });
});
</script>

</body>
</html>
