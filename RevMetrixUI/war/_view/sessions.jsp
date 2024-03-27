<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Bowling Sessions</title>
    <link rel="stylesheet" type="text/css" href="CSS/sessionsStyles.css">
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <div class="topPage">
        <h1>Bowling Sessions</h1>
    </div>
    
    <!-- Display selected event details -->
    <div class="selected-event">
        <h2>Bowling Event</h2>
        <p><strong>Date:</strong> January 1, 2024</p>
        <p><strong>Location:</strong> Bowling Center</p>
        <p><strong>Description:</strong> Enjoy a fun-filled bowling session with friends</p>
    </div>
    
    <!-- Display sessions and games for the selected event -->
    <div class="section">
        <div class="section-title">Sessions for your event</div>
        <div class="sessions">
            <!-- Session 1 -->
            <div class="session">
                <h2>Afternoon Session</h2>
                <p><strong>Date:</strong> January 1, 2024</p>
                <p><strong>Location:</strong> XYZ Bowling Center</p>
                <p><strong>Description:</strong> Afternoon bowling session for families and friends.</p>
                <p><strong>Capacity:</strong> 50</p>
                <!-- Games for Session 1 -->
                <div class="games">
                    <h3>Games</h3>
                    <ul>
                        <!-- Hardcoded game details for Session 1 -->
                        <li>Game 1: Score - 150, Player - John</li>
                        <li>Game 2: Score - 180, Player - Emily</li>
                        <li>Game 3: Score - 200, Player - Mike</li>
                    </ul>
                </div>
            </div>
            
            <!-- Session 2 -->
            <div class="session">
                <h2>Evening Session</h2>
                <p><strong>Date:</strong> January 1, 2024</p>
                <p><strong>Location:</strong> Bowling Center</p>
                <p><strong>Description:</strong> Evening bowling session for adults.</p>
                <p><strong>Capacity:</strong> 30</p>
                <!-- Games for Session 2 -->
                <div class="games">
                    <h3>Games</h3>
                    <ul>
                        <!-- Hardcoded game details for Session 2 -->
                        <li>Game 1: Score - 190, Player - Sarah</li>
                        <li>Game 2: Score - 170, Player - Tom</li>
                        <li>Game 3: Score - 210, Player - Emma</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
