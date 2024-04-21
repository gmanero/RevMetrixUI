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
            <p>Game Number: 1</p>
            <p>Lane Number: 1</p>
            <p id="shotNumber">Shot Number: ${game.getShotNum()}</p>
            <p id="pinsRemaining">Pins Remaining: ${game.pinsRemain}</p>
            
            
        </div>

	<div class = "interactions">
	<div class="scoreboard">
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">a</div>
                <div id = "split1" class="shot-box">${shotScores[0]}</div>
                <div class="shot-box">${shotScores[1]}</div>
            </div>
            <div class="score-running">${scores[0]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split2" class="shot-box">${shotScores[2]}</div>
                <div class="shot-box">${shotScores[3]}</div>
            </div>
            <div class="score-running">${scores[1]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split3" class="shot-box">${shotScores[4]}</div>
                <div class="shot-box">${shotScores[5]}</div>
            </div>
            <div class="score-running">${scores[2]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split4" class="shot-box">${shotScores[6]}</div>
                <div class="shot-box">${shotScores[7]}</div>
            </div>
            <div class="score-running">${scores[3]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split5" class="shot-box">${shotScores[8]}</div>
                <div class="shot-box">${shotScores[9]}</div>
            </div>
            <div class="score-running">${scores[4]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split6" class="shot-box">${shotScores[10]}</div>
                <div class="shot-box">${shotScores[11]}</div>
            </div>
            <div class="score-running">${scores[5]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split7" class="shot-box">${shotScores[12]}</div>
                <div class="shot-box">${shotScores[13]}</div>
            </div>
            <div class="score-running">${scores[6]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split8" class="shot-box">${shotScores[14]}</div>
                <div class="shot-box">${shotScores[15]}</div>
            </div>
            <div class="score-running">${scores[7]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap"></div>
                <div id = "split9" class="shot-box">${shotScores[16]}</div>
                <div class="shot-box">${shotScores[17]}</div>
            </div>
            <div class="score-running">${scores[8]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div id = "split10" class="shot-box">${shotScores[18]}</div>
                <div id = "split11" class="shot-box">${shotScores[19]}</div>
                <div class="shot-box">${shotScores[20]}</div>
            </div>
            <div class="score-running">${scores[9]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-box">${event_score}</div>
            </div>
            <div class="score-running">${scores[10]}</div>
        </div>
    </div>
<form  action="${pageContext.servletContext.contextPath}/game" method="post">

<div class="NewPinContainer">
  <div class="rowNew">
    <div class="gameFrameHeaderNew">
      <label>${error}</label>
    </div>
  </div>
  <div class="rowNew">
    <div class="pinNew" onclick="togglePin(this,7)"><span>7</span></div>
    <div class="pinNew" onclick="togglePin(this,8)"><span>8</span></div>
    <div class="pinNew" onclick="togglePin(this,9)"><span>9</span></div>
    <div class="pinNew" onclick="togglePin(this,0)"><span>10</span></div>
  </div>
  <div class="rowNew">
    <div class="pinNew" onclick="togglePin(this,4)"><span>4</span></div>
    <div class="pinNew" onclick="togglePin(this,5)"><span>5</span></div>
    <div class="pinNew" onclick="togglePin(this,6)"><span>6</span></div>
  </div>
  <div class="rowNew">
    <div class="pinNew" onclick="togglePin(this,2)"><span>2</span></div>
    <div class="pinNew" onclick="togglePin(this,3)"><span>3</span></div>
  </div>
  <div class="rowNew">
    <div class="pinNew" onclick="togglePin(this,1)"><span>1</span></div>
  </div>
  <div class="rowNew">
    <div class="firstShot" onclick="setFirstShot()" style="background-color: #26acca;"><span> </span></div>
    <div class="secondShot" onclick="setSecondShot()" style="background-color: lightgrey;"><span> </span></div>
  </div>
  <div class="rowNew">
    <div class="foul" onclick="setFoul()"><span>F</span></div>
    <div class="miss" onclick="setGutter()"><span>-</span></div>
    <div class="strike" onclick="setStrike()"><span>X</span></div>
    <div class="spare" onclick="setSpare()"><span>/</span></div>
  </div>
  <div class="rowNew">
    <input class="button" type="Submit" name="submit" value="< Previous" onclick="getPreviousFrame()">
    <input class="button" type="Submit" name="submit" value="Next Frame >" onclick="getNextFrame()">
    
    <input type = "hidden" name = "firstRemaining" id = 'firstRemaining' value = "">
    <input type = "hidden" name = "secondRemaining" id = 'secondRemaining' value = "">
    <input type = "hidden" name = "firstExtra" id = 'firstExtra' value = "">
    <input type = "hidden" name = "secondExtra" id = 'secondExtra' value = "">
  </div>

   
  
</div>
</form>		      
        
    </div>
    
    
	</div>
        <div class="stats">
            <h2>Game Statistics</h2>
            <p>Total Strikes: ${game.getTotStrike()}</p>
            <p>Total Spares: ${game.getTotSpare()}</p>
            <p>Total Gutters: ${game.getTotGutter()}</p>
            <p>Total Fouls: ${game.getTotFoul()}</p>
        </div>
	
        
         
   
    </div>

    <script>
  // constants for shot variable
  const FIRST_SHOT  = 1;
  const SECOND_SHOT = 2;

  var first_Remaining = [];
  var second_Remaining = [];
  // constants for NO and ALL pins kocked down
  const NO_PINS  = 0;
  const ALL_PINS = 10;

  // constants for frame limits
  const MIN_FRAMES = 1;
  const MAX_FRAMES = 12;

  // declare and initialize global variables
  let pinCount        = NO_PINS;		// intermediate pin count
  let firstShotCount  = NO_PINS;		// count of pins knocked down on first shot
  let secondShotCount = NO_PINS;		// count of pins knocked down on second shot
  let shot 			= FIRST_SHOT;	// start with first shot

  // TODO: when there is a server/application setting these, remove this
  // setting these here until they are sent down by the server
  let frameNumber = 1;
  let gameNumber  = 1;

  //********************************************************************************
  // This code initializes the display values through JS upon entry to the page
  //********************************************************************************

  // TODO: change this to initialize to values sent from server
  // initialize Game and Frame
  document.getElementById('frameNum').value = frameNumber;
  document.getElementById('gameNum').value = gameNumber;

  // select first shot to start
  setFirstShot();

  //************************************************************************

  function togglePin(pin,num) {
    // toggle the class of the clicked pin
    pin.classList.toggle("leave");

    // count the number of pins knocked down
    const pins = document.querySelectorAll('.pinNew:not(.leave)');

    // update pinCount with the # of pins knocked down
    pinCount = pins.length;

    // first shot?
    if (shot == FIRST_SHOT) {
      // update first shot count
      firstShotCount = pinCount;
      document.getElementById('firstExtra').value= '';
      if (first_Remaining.includes(num)) {
        first_Remaining = first_Remaining.filter(n => n !== num);
        second_Remaining = second_Remaining.filter(n => n !== num);
      } else {
        first_Remaining.push(num);
        second_Remaining.push(num);
      }

      // strike?
      if (firstShotCount == ALL_PINS) {
        // display 'X'
        setStrike();
      }
      // otherwise, display count
      else {
        // update firstShot w/pinCount
        document.querySelector('.firstShot span').textContent = firstShotCount;

        // clear secondShot whenever firstShot changes
        clearSecondShot();
      }
    }
    // otherwise, second shot
    else {
      // calculate second shot count
      // pins left standing after first shot - pins left standing after second shot
      // reduces to pinCount - firstShotCount
      secondShotCount = pinCount - firstShotCount
      document.getElementById('secondExtra').value = '';
      if (second_Remaining.includes(num)) {

        second_Remaining = second_Remaining.filter(n => n !== num);
      } else {

        second_Remaining.push(num);
      }
      // spare?
      if (pinCount == ALL_PINS) {
        // display ('/')
        document.querySelector('.secondShot span').textContent = '/';
      }
      // if missed all pins
      else if (secondShotCount == NO_PINS) {
        // display '-', rather than '0' in second shot
        document.querySelector('.secondShot span').textContent = '-';
      }
      // otherwise, display pin count
      else {
        // update secondShot w/pinCount
        document.querySelector('.secondShot span').textContent = secondShotCount;
      }
    }
    
    first_Remaining.sort();
    second_Remaining.sort();
    var firstLoaction = document.getElementById('firstRemaining');
    var SecondLocation = document.getElementById('secondRemaining');

    firstLoaction.value = first_Remaining.join(",");
    SecondLocation.value = second_Remaining.join(",");


  }

  function clearPins() {
    var pins = document.querySelectorAll('.pinNew');
    pins.forEach(function(pin) {
      pin.classList.remove('leave');
    });
  }

  function setAllPinsStanding() {
    var pins = document.querySelectorAll('.pinNew');
    
    pins.forEach(function(pin) {
      pin.classList.add('leave');
    })

    ;

    // reset all counts
    resetPinCounts();

    // clear secondShot whenever firstShot changes
    clearSecondShot();
  }

  // set gutter for current shot
  function setGutter() {
    // gutter on first shot?
    if (shot == FIRST_SHOT) {
      // set up all pins
      setAllPinsStanding();

      // clear secondShot whenever firstShot changes
      clearSecondShot();

      // display '-', rather than '0' in first shot
      document.querySelector('.firstShot span').textContent = '-';
    }
    // otherwise, gutter on second shot
    else {
      // display '-', rather than '0' in second shot
      document.querySelector('.secondShot span').textContent = '-';
      second_Remaining = first_Remaining;
    }

  }

  // set foul for current shot
  function setFoul() {
    // foul on first shot?
    if (shot == FIRST_SHOT) {
      // set up all pins
      setAllPinsStanding();

      // clear secondShot whenever firstShot changes
      clearSecondShot();
      first_Remaining = [1,2,3,4,5,6,7,8,9,0];
      document.getElementById('firstExtra').value= 'F';
      // display 'F', rather than '0' in first shot
      document.querySelector('.firstShot span').textContent = 'F';
    }
    // otherwise, foul on second shot
    else {
      // display 'F', rather than '0' in second shot
      document.querySelector('.secondShot span').textContent = 'F';
      document.getElementById('secondExtra').value = 'F';
      second_Remaining= first_Remaining;
    }
    first_Remaining.sort();
    second_Remaining.sort();
    var firstLoaction = document.getElementById('firstRemaining');
    var SecondLocation = document.getElementById('secondRemaining');

    firstLoaction.value= first_Remaining.join(",");
    SecondLocation.value=second_Remaining.join(",");
  }

  function setFirstShot() {
    // set the shot # to first
    shot = FIRST_SHOT;
    document.querySelector('.firstShot').style.backgroundColor = '#26acca';
    document.querySelector('.secondShot').style.backgroundColor = 'lightgrey';
    clearFirstShot();
    clearSecondShot();
    clearPins();
    resetPinCounts();
    
  }

  function setSecondShot() {
    // set the shot # to second
    shot = SECOND_SHOT;

    document.querySelector('.secondShot').style.backgroundColor = '#26acca';
    document.querySelector('.firstShot').style.backgroundColor = 'lightgrey';
  }

  function clearFirstShot() {
    // Clear the content of firstShot
    document.querySelector('.firstShot span').textContent = ' ';
  }

  function clearSecondShot() {
    // Clear the content of secondShot
    document.querySelector('.secondShot span').textContent = ' ';
  }

  function resetPinCounts() {
    pinCount        = NO_PINS;
    firstShotCount  = NO_PINS;
    secondShotCount = NO_PINS;
    first_Remaining = [];
    second_Remaining = [];
    first_Remaining.sort();
    second_Remaining.sort();
    var firstLoaction = document.getElementById('firstRemaining');
    var SecondLocation = document.getElementById('secondRemaining');

    firstLoaction.value= first_Remaining.join(",");
    SecondLocation.value=second_Remaining.join(",");
  }

  function setSpare() {
    // clear all pins
    clearPins();

    // switch to second shot
    setSecondShot();

    // update firstShot with most recent result
    // keep 'F' or '-'
    if (document.querySelector('.firstShot span').textContent !== '-') {
      if (document.querySelector('.firstShot span').textContent !== 'F') {					// update firstShot with most recent pinCount (from first ball)
        document.querySelector('.firstShot span').textContent = firstShotCount;
      }
    }
    // set secondShot for a spare ('/')
    document.querySelector('.secondShot span').textContent = '/';
    second_Remaining = [];
    
    first_Remaining.sort();
    second_Remaining.sort();
    var firstLoaction = document.getElementById('firstRemaining');
    var SecondLocation = document.getElementById('secondRemaining');

    firstLoaction.value= first_Remaining.join(",");
    SecondLocation.value=second_Remaining.join(",");
  }

  function setStrike() {
    // clear all pins, and firstShot, then put 'X' in secondShot
    clearPins();

    // switch to first shot
    setFirstShot();

    // reset all counts;
    resetPinCounts();

    // 'X' is displayed in second square
    clearFirstShot();

    // set secondShot for a strike ('X')
    document.querySelector('.secondShot span').textContent = 'X';

    first_Remaining = [];
    second_Remaining = [];
    
    first_Remaining.sort();
    second_Remaining.sort();
    var firstLoaction = document.getElementById('firstRemaining');
    var SecondLocation = document.getElementById('secondRemaining');

    firstLoaction.value= first_Remaining.join(",");
    SecondLocation.value=second_Remaining.join(",");
  }

  function getPreviousShot() {
    // unused - does nothing, yet
    first_Remaining = [];
    second_Remaining = [];
    var firstLoaction = document.getElementById('firstRemaining');
    var SecondLocation = document.getElementById('secondRemaining');

    firstLoaction.value= first_Remaining.join(",");
    SecondLocation.value=second_Remaining.join(",");
  }

  function getNextShot() {
    first_Remaining = [];
    second_Remaining = [];
    var firstLoaction = document.getElementById('firstRemaining');
    var SecondLocation = document.getElementById('secondRemaining');

    firstLoaction.value= first_Remaining.join(",");
    SecondLocation.value=second_Remaining.join(",");
  }

  function getPreviousFrame() {
    // clear all pins
    clearPins();

    //clear all pin counts
    resetPinCounts();

    // clear the content of firstShot
    document.querySelector('.firstShot span').textContent = ' ';

    // clear the content of secondShot
    document.querySelector('.secondShot span').textContent = ' ';

    // start with first shot
    setFirstShot();

    // TODO: remove this when server/application is calculating it
    //       for now, update frame number
    if (frameNumber > MIN_FRAMES) {
      frameNumber--;
      document.getElementById('frameNum').value = frameNumber;
    }

    // TODO: this will have to pull from the DB to get the previous shot info,
    //       and then reconstruct the frame
    //         what do you do with the existing frame data?


  }
  function getNextFrame() {
    // clear all pins
    //clearPins();

    //clear all pin counts
    //resetPinCounts();

    // clear the content of firstShot
    //document.querySelector('.firstShot span').textContent = ' ';

    // clear the content of secondShot
    //document.querySelector('.secondShot span').textContent = ' ';

    // start with first shot
    //setFirstShot();

    // TODO: remove this when server/application is calculating it
    //       for now, update frame number
    if (frameNumber < MAX_FRAMES) {
      frameNumber++;
      document.getElementById('frameNum').value = frameNumber;
    }

    // TODO: if this is a new frame, then gather the info for the frame,
    //          submit it to the server, and start a new frame
    //       if this is an existing frame, then gather the info for the frame,
    //          and get the next frame from the server
    //		 if this is the last frame of the game, then what?
    //          next game in Session, what if it is the last game of the Session?


  }
  function Split(i) {
      document.getElementById("split"+i).className = "shot-box-split";
  }

</script>
</body>

</html>