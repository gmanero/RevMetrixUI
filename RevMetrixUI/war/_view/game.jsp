<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Current Game</title>
    <link rel = "stylesheet" type ="text/css" href="CSS/gameStyles.css">
</head>

<body>
    <div class="topPage">
        <h1>Current Game</h1>
    </div>
    
    
          <form method= "get">
    <div class="links">
        <button type="submit" name="destination" value="revMetrix" class="button">RevMetrix</button>
        <button type="submit" name="destination" value="events" class="button">Events</button>
        <button type="submit" name="destination" value="register" class="button">Register</button>
        <button type="submit" name="destination" value="stats" class="button">Stats</button>
        <button type="submit" name="destination" value="game" class="button">Your Game</button>
         <button type="submit" name="destination" value="login" class="button">Login</button>
          <button type="submit" name="destination" value="account" class="button">Account</button>
    </div>
     </form>
    

    <div class="mainText">
        <div class="gameInfo">
            <h2>Welcome to the Bowling Game</h2>
            <p>Game Number: 1</p>
            <p>Lane Number: 5</p>
            <p id="shotNumber">Shot Number: 1</p>
            <p>Score: 0</p>
            <p id="pinsKnockedDown">Pins Knocked Down: 0</p>
            <p id="pinsRemaining">Pins Remaining: 10</p>
            <button class="button" onclick="nextShot()">Next Shot</button>
        </div>
	<div>
	<div class="scoreboard">
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">a</div>
                <div class="shot-box">${firstFrame_shot1}</div>
                <div class="shot-box">${firstFrame_shot2}</div>
            </div>
            <div class="score-running">${firstFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div class="shot-box">${secondFrame_shot1}</div>
                <div class="shot-box">${secondFrame_shot2}</div>
            </div>
            <div class="score-running">${secondFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div class="shot-box">${thirdFrame_shot1}</div>
                <div class="shot-box">${thirdFrame_shot2}</div>
            </div>
            <div class="score-running">${thirdFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div class="shot-box">${forthFrame_shot1}</div>
                <div class="shot-box">${forthFrame_shot2}</div>
            </div>
            <div class="score-running">${forthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div class="shot-box">${fifthFrame_shot1}</div>
                <div class="shot-box">${fifthFrame_shot2}</div>
            </div>
            <div class="score-running">${fifthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div class="shot-box">${sixthFrame_shot1}</div>
                <div class="shot-box">${sixthFrame_shot2}</div>
            </div>
            <div class="score-running">${sixthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div class="shot-box">${seventhFrame_shot1}</div>
                <div class="shot-box">${seventhFrame_shot2}</div>
            </div>
            <div class="score-running">${seventhFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div class="shot-box">${eighthFrame_shot1}</div>
                <div class="shot-box">${eighthFrame_shot2}</div>
            </div>
            <div class="score-running">${eigthFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div class="shot-box">${ninthFrame_shot1}</div>
                <div class="shot-box">${ninthFrame_shot2}</div>
            </div>
            <div class="score-running">${ninethFrame_score}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-box">${tenthFrame_shot1}</div>
                <div class="shot-box">${tenthFrame_shot2}</div>
                <div class="shot-box">${tenthFrame_shot3}</div>
            </div>
            <div class="score-running">${tenthFrame_score}</div>
        </div>
    </div>
		
	</div>
        <div class="stats">
            <h2>Game Statistics</h2>
            <p>Total Strikes: 0</p>
            <p>Total Spares: 0</p>
            <p>Total Misses: 0</p>
        </div>

        <div class="bowling-pins">
            <div class="pin-row">
                <div class="pin">
                    <input type="checkbox" id="Pin1" name="Pin1" value="Pin1">
                </div>
            </div>
            <div class="pin-row">
                <div class="pin">
                    <input type="checkbox" id="Pin2" name="Pin2" value="Pin2">
                </div>
                <div class="pin">
                    <input type="checkbox" id="Pin3" name="Pin3" value="Pin3">
                </div>
            </div>
            <div class="pin-row">
                <div class="pin">
                    <input type="checkbox" id="Pin4" name="Pin4" value="Pin4">
                </div>
                <div class="pin">
                    <input type="checkbox" id="Pin5" name="Pin5" value="Pin5">
                </div>
                <div class="pin">
                    <input type="checkbox" id="Pin6" name="Pin6" value="Pin6">
                </div>
            </div>
            <div class="pin-row">
                <div class="pin">
                    <input type="checkbox" id="Pin7" name="Pin7" value="Pin7">
                </div>
                <div class="pin">
                    <input type="checkbox" id="Pin8" name="Pin8" value="Pin8">
                </div>
                <div class="pin">
                    <input type="checkbox" id="Pin9" name="Pin9" value="Pin9">
                </div>
                <div class="pin">
                    <input type="checkbox" id="Pin10" name="Pin10" value="Pin10">
                </div>
            </div>
        </div>
    </div>

    <script>
        let currentShot = 1;
        
        function nextShot() {
            currentShot++;
            document.getElementById('shotNumber').textContent = `Shot Number: ${currentShot}`;
        }
    </script>
</body>

</html>
