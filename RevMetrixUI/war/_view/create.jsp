<%@ page import="java.util.List" %>
<%@ page import="revMetrix.db.model.Establishment" %>
<%@ page import="revMetrix.controller.EstablishmentController" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Event</title>
    <style>
        /* Basic Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #1f1f1f;
            color: #fff;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #333;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #fff;
        }

        input[type="text"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            background-color: #444;
            color: #fff;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #26acca;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #316477;
        }

        #newEstablishmentDiv {
            display: none;
        }
    </style>
</head>

<body>

    <div class="container">
        <h2>Create Event</h2>
        <form action="${pageContext.servletContext.contextPath}/create" method="post">
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
            <div id="newEstablishmentDiv" class="form-group">
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
                document.getElementById("newEstablishment").value = "";
            }
        }
    </script>

</body>

</html>
