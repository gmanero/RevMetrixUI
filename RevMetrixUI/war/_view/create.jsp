<%@ page import="java.util.List" %>
<%@ page import="revMetrix.db.model.Establishment" %>
<%@ page import="revMetrix.controller.EstablishmentController" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Event</title>
    <link rel="stylesheet" type="text/css" href="CSS/createLeagueStyles.css">
</head>

<body>
<jsp:include page="navbar.jsp" />
	<div class="topPage">
        <h1>RevMetrix - Create an Event</h1>
    </div>
    <div class="container">
        <h2>Create Event</h2>
        <form action="${pageContext.servletContext.contextPath}/game" method="post">
            <div class="form-group">
                <label for="eventName">Event Name:</label>
                <input type="text" id="eventName" name="eventName" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" required></textarea>
            </div>
            <div class="form-group">
                <label for="establishment">Establishment:</label>
                <select id="establishment" name="establishment" onchange="toggleAddNew()" required>
                    <%
                        EstablishmentController establishmentController = new EstablishmentController();
                        List<Establishment> establishments = establishmentController.getAllEstablishments();
                        if (establishments != null && !establishments.isEmpty()) {
                            for (Establishment establishment : establishments) {
                    %>
                    <option value="<%= establishment.getName()%>"><%= establishment.getName() %></option>
                    <%
                            }
                        }
                    %>
                    <option value="addNew">Add New</option>
                </select>
            </div>
            <div id="newEstablishmentDiv" class="form-group" style="display: none;">
                <label for="newEstablishment">New Establishment Name:</label>
                <input type="text" id="newEstablishment" name="newEstablishment" placeholder="New Establishment Name">
            </div>
            <div class="form-group">
                <label for="eventType">Event Type:</label>
                <select id="eventType" name="eventType" required>
                    <option value="practice">Practice</option>
                    <option value="league">League</option>
                    <option value="tournament">Tournament</option>
                </select>
            </div>
            <input type="submit" value="Create Event">
        </form>
    </div>

    <script>
        function toggleAddNew() {
            var select = document.getElementById("establishment");
            var newEstablishmentDiv = document.getElementById("newEstablishmentDiv");

            if (select.value === "addNew") {
                newEstablishmentDiv.style.display = "block";
                document.getElementById("newEstablishment").focus();
            } else {
                newEstablishmentDiv.style.display = "none";
            }
        }
    </script>

</body>

</html>
