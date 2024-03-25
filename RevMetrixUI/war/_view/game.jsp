<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Current Game</title>
    <link rel = "stylesheet" type ="text/css" href="CSS/gameStyles.css">
</head>

<body>
 <jsp:include page="navbar.jsp" />
    <div class="topPage">
        <h1>Current Game</h1>
    </div>
    
    
        
    <div class="mainText">
        <div class="gameInfo">
            <h2>Welcome to the Bowling Game</h2>
            <p>Game Number: ${gameNumber }</p>
            <p>Lane Number: ${laneNumber }</p>
            <p id="shotNumber">Shot Number: ${shotNumber}</p>
            <p id="pinsKnockedDown">Pins Knocked Down: ${pinsKnockedDown}</p>
            <p id="pinsRemaining">Pins Remaining: ${pinsRemianing}</p>
            <form  action="${pageContext.servletContext.contextPath}/game" method="post">
            <button class="button" type="submit" value="submit">Next Shot</button>
            <input type="hidden" name = "clickedPins" id = "output" value="">
            </form>
            
        </div>
	<div class = "stats">
	<div class="scoreboard">
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">a</div>
                <div id = "split1" class="shot-box">${firstFrame_shot1}</div>
                <div class="shot-box">${firstFrame_shot2}</div>
            </div>
            <div class="score-running">${firstFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split2" class="shot-box">${secondFrame_shot1}</div>
                <div class="shot-box">${secondFrame_shot2}</div>
            </div>
            <div class="score-running">${secondFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split3" class="shot-box">${thirdFrame_shot1}</div>
                <div class="shot-box">${thirdFrame_shot2}</div>
            </div>
            <div class="score-running">${thirdFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split4" class="shot-box">${forthFrame_shot1}</div>
                <div class="shot-box">${forthFrame_shot2}</div>
            </div>
            <div class="score-running">${forthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split5" class="shot-box">${fifthFrame_shot1}</div>
                <div class="shot-box">${fifthFrame_shot2}</div>
            </div>
            <div class="score-running">${fifthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split6" class="shot-box">${sixthFrame_shot1}</div>
                <div class="shot-box">${sixthFrame_shot2}</div>
            </div>
            <div class="score-running">${sixthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split7" class="shot-box">${seventhFrame_shot1}</div>
                <div class="shot-box">${seventhFrame_shot2}</div>
            </div>
            <div class="score-running">${seventhFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split8" class="shot-box">${eighthFrame_shot1}</div>
                <div class="shot-box">${eighthFrame_shot2}</div>
            </div>
            <div class="score-running">${eighthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split9" class="shot-box">${ninthFrame_shot1}</div>
                <div class="shot-box">${ninthFrame_shot2}</div>
            </div>
            <div class="score-running">${ninethFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div id = "split10" class="shot-box">${tenthFrame_shot1}</div>
                <div id = "split11" class="shot-box">${tenthFrame_shot2}</div>
                <div class="shot-box">${tenthFrame_shot3}</div>
            </div>
            <div class="score-running">${tenthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-box">${event_score}</div>
            </div>
            <div class="score-running">${current_score}</div>
        </div>
    </div>
		<div>
        <!-- Container for bowling pins -->
        <div class="pin-container">
            <!-- Set of bowling pins -->
            <div class="pin" id="pin1" onclick="togglePin(this, 1)"></div>
            <div class="pin" id="pin2" onclick="togglePin(this, 2)"></div>
            <div class="pin" id="pin3" onclick="togglePin(this, 3)"></div>
            <div class="pin" id="pin4" onclick="togglePin(this, 4)"></div>
            <div class="pin" id="pin5" onclick="togglePin(this, 5)"></div>
            <div class="pin" id="pin6" onclick="togglePin(this, 6)"></div>
            <div class="pin" id="pin7" onclick="togglePin(this, 7)"></div>
            <div class="pin" id="pin8" onclick="togglePin(this, 8)"></div>
            <div class="pin" id="pin9" onclick="togglePin(this, 9)"></div>
            <div class="pin" id="pin10" onclick="togglePin(this, 10)"></div>
        </div>
        <br class="gap">
		<form  action="${pageContext.servletContext.contextPath}/game" method="post">
            <button class="button" type="submit" value="submit">Foul</button>
            <input type="hidden" name = "clickedPins" id = "output" value="F,">
            </form>
       	<form  action="${pageContext.servletContext.contextPath}/game" method="post">
            <button class="button" type="submit" value="submit">strikeSpare</button>
            <input type="hidden" name = "clickedPins" id = "output" value="1,2,3,4,5,6,7,8,9,10">
            </form>
		<form  action="${pageContext.servletContext.contextPath}/game" method="post">
            <button class="button" type="submit" value="submit">Gutter</button>
            <input type="hidden" name = "clickedPins" id = "output" value="G,">
            </form>
    </div>
    
    <p>Hit Pins: <span id="clickedPins"></span></p>
	</div>
        <div class="stats">
            <h2>Game Statistics</h2>
            <p>Total Strikes: ${strikes}</p>
            <p>Total Spares: ${spares}</p>
            <p>Total Misses: ${misses}</p>
        </div>
	
        
         
   
    </div>

    <script>
    var clickedPins = [];

    function Split(int i) {
        document.getElementById("split"+i).className = "shot-box-split";
    }
    function togglePin(pin, pinNumber) {
        // Toggle class to change background color
        pin.classList.toggle('clicked');

        // Update array of clicked pins
        if (clickedPins.includes(pinNumber)) {
            clickedPins = clickedPins.filter(num => num !== pinNumber);
        } else {
            clickedPins.push(pinNumber);
        }
        clickedPins.sort();
        // Update display of clicked pins
        document.getElementById('clickedPins').textContent = clickedPins.join(', ');
        document.getElementsByID('output').value = document.getElementById('clickedPins').textContent;
    }
</script>
</body>

</html>
