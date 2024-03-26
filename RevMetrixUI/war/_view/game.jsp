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
            
            
        </div>

	<div class = "interactions">
	<div class="scoreboard">
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">a</div>
                <div id = "split1" class="shot-box">${game.scoreBoard[0]}</div>
                <div class="shot-box">${game.scoreBoard[1]}</div>
            </div>
            <div class="score-running">${Frame1_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split2" class="shot-box">${game.scoreBoard[2]}</div>
                <div class="shot-box">${game.scoreBoard[3]}</div>
            </div>
            <div class="score-running">${Frame2_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split3" class="shot-box">${game.scoreBoard[4]}</div>
                <div class="shot-box">${game.scoreBoard[5]}</div>
            </div>
            <div class="score-running">${Frame3_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split4" class="shot-box">${game.scoreBoard[6]}</div>
                <div class="shot-box">${game.scoreBoard[7]}</div>
            </div>
            <div class="score-running">${Frame4_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split5" class="shot-box">${game.scoreBoard[8]}</div>
                <div class="shot-box">${game.scoreBoard[9]}</div>
            </div>
            <div class="score-running">${Frame5_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split6" class="shot-box">${game.scoreBoard[10]}</div>
                <div class="shot-box">${game.scoreBoard[11]}</div>
            </div>
            <div class="score-running">${Frame6_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split7" class="shot-box">${game.scoreBoard[12]}</div>
                <div class="shot-box">${game.scoreBoard[13]}</div>
            </div>
            <div class="score-running">${Frame7_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split8" class="shot-box">${game.scoreBoard[14]}</div>
                <div class="shot-box">${game.scoreBoard[15]}</div>
            </div>
            <div class="score-running">${Frame8_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split9" class="shot-box">${game.scoreBoard[16]}</div>
                <div class="shot-box">${game.scoreBoard[17]}</div>
            </div>
            <div class="score-running">${Frame9_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div id = "split10" class="shot-box">${game.scoreBoard[18]}</div>
                <div id = "split11" class="shot-box">${game.scoreBoard[19]}</div>
                <div class="shot-box">${game.scoreBoard[20]}</div>
            </div>
            <div class="score-running">${Frame10_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-box">${event_score}</div>
            </div>
            <div class="score-running">${current_score}</div>
        </div>
    </div>
		<div class="main-container">
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
         <span class="gap"></span>
         <div  class="hit-pins"><p>Hit Pins: <span id="clickedPins"></span></p></div>
        <div class=buttons-container>
         
        	<form  action="${pageContext.servletContext.contextPath}/game" method="post">
            <button class="button" type="submit" value="submit">Next Shot</button>
            <input type="hidden" name = "clickedPins" id = "score" value="">
            </form>
		<form  action="${pageContext.servletContext.contextPath}/game" method="post">
            <button class="button" type="submit" value="submit">Foul</button>
            <input type="hidden" name = "clickedPins"  value="F,">
            </form>
       	<form  action="${pageContext.servletContext.contextPath}/game" method="post">
            <button class="button" type="submit" value="submit">strikeSpare</button>
            <input type="hidden" name = "clickedPins"  value="1,2,3,4,5,6,7,8,9,10">
            </form>
		<form  action="${pageContext.servletContext.contextPath}/game" method="post">
            <button class="button" type="submit" value="submit">Gutter</button>
            <input type="hidden" name = "clickedPins"  value="G,">
            </form>
        </div>
       
        
    </div>
    
    
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
        var clickedPinsContent = document.getElementById("clickedPins").innerText;

     // Set the value of the input element with id "score" to the content of the span element
     document.getElementById("score").value = clickedPinsContent;
    }
    function Split(i) {
        document.getElementById("split"+i).className = "shot-box-split";
    }
</script>
</body>

</html>
