<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RevMetrix - Current Game</title>
    <link rel = "stylesheet" type ="text/css" href="CSS/gameStyles.css">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body onload="Startup()">
 <jsp:include page="navbar.jsp" />
    <div class="topPage">
        <h1>Current Game</h1>
       
    </div>
    
<div class="center2">
	
	<div class = "interactions">
	<div class="scoreboard">
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[0]}</div>
                <div class="shot-box"><div id = split1 class=""> ${shotScores[0]}</div></div>
                <div class="shot-box">${shotScores[1]}</div>
            </div>
            <div class="score-running">${scores[0]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[1]}</div>
                <div class="shot-box"><div id = "split2" class="">${shotScores[2]}</div></div>
                <div class="shot-box">${shotScores[3]}</div>
            </div>
            <div class="score-running">${scores[1]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[2]}</div>
                <div class="shot-box"><div id = split3 class="">${shotScores[4]}</div></div>
                <div class="shot-box">${shotScores[5]}</div>
            </div>
            <div class="score-running">${scores[2]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[3]}</div>
                <div class="shot-box"><div id = split4 class="">${shotScores[6]}</div></div>
                <div class="shot-box">${shotScores[7]}</div>
            </div>
            <div class="score-running">${scores[3]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[4]}</div>
                <div class="shot-box"><div id = split5 class="">${shotScores[8]}</div></div>
                <div class="shot-box">${shotScores[9]}</div>
            </div>
            <div class="score-running">${scores[4]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[5]}</div>
                <div class="shot-box"><div id = split6 class="">${shotScores[10]}</div></div>
                <div class="shot-box">${shotScores[11]}</div>
            </div>
            <div class="score-running">${scores[5]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[6]}</div>
                <div class="shot-box"><div id = split7 class="">${shotScores[12]}</div></div>
                <div class="shot-box">${shotScores[13]}</div>
            </div>
            <div class="score-running">${scores[6]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[7]}</div>
                <div class="shot-box"><div id = split8 class="">${shotScores[14]}</div></div>
                <div class="shot-box">${shotScores[15]}</div>
            </div>
            <div class="score-running">${scores[7]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-gap">${washout[8]}</div>
                <div class="shot-box"><div id = split9 class="">${shotScores[16]}</div></div>
                <div class="shot-box">${shotScores[17]}</div>
            </div>
            <div class="score-running">${scores[8]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-box"><div id = split10 class="">${shotScores[18]}</div></div>
                <div class="shot-box"><div id = split11 class="">${shotScores[19]}</div></div>
                <div class="shot-box">${shotScores[20]}</div>
            </div>
            <div class="score-running">${scores[9]}</div>
        </div>
        <div class="score-box">
            <div class="score-upper">
                <div class="shot-box"></div>
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
    <div class="pinNew" id= "pin7" onclick="togglePin(this,7)"><span>7</span></div>
    <div class="pinNew" id= "pin8" onclick="togglePin(this,8)"><span>8</span></div>
    <div class="pinNew" id= "pin9" onclick="togglePin(this,9)"><span>9</span></div>
    <div class="pinNew" id= "pin0" onclick="togglePin(this,0)"><span>10</span></div>
  </div>
  <div class="rowNew">
    <div class="pinNew" id= "pin4" onclick="togglePin(this,4)"><span>4</span></div>
    <div class="pinNew" id= "pin5" onclick="togglePin(this,5)"><span>5</span></div>
    <div class="pinNew" id= "pin6" onclick="togglePin(this,6)"><span>6</span></div>
  </div>
  <div class="rowNew">
    <div class="pinNew" id= "pin2" onclick="togglePin(this,2)"><span>2</span></div>
    <div class="pinNew" id= "pin3" onclick="togglePin(this,3)"><span>3</span></div>
  </div>
  <div class="rowNew">
    <div class="pinNew" id= "pin1" onclick="togglePin(this,1)"><span>1</span></div>
  </div>
  <div class="rowNew">
    <div class="firstShot" style="display: none;" onclick="setFirstShot()" style="background-color: #26acca;"><span> </span></div>
    <div class="secondShot" style="display: none;" onclick="setSecondShot()" style="background-color: lightgrey;" ><span> </span></div>
  </div>
  <div class="rowNew">
    <div class="foulbtn" onclick="setFoul()" style="background-color: lightgrey;"><span>F</span></div>
    <div class="missbtn" onclick="setGutter()" style="background-color: lightgrey;"><span>-</span></div>
    <div class="strikebtn" onclick="setStrike()" style="background-color: lightgrey;"><span>X</span></div>
    <div class="sparebtn" style="display: none;" onclick="setSpare()" style="background-color: lightgrey;"><span>/</span></div>
  </div>
  <div class="rowNew">
    <input id = "nextShotButton" class="button" type="Submit" name="submit" value="Next Shot >" onclick="getNextFrame()">
    
    <input type = "hidden" name = "firstRemaining" id = 'firstRemaining' value = "">
    <input type = "hidden" name = "secondRemaining" id = 'secondRemaining' value = "">
    <input type = "hidden" name = "firstExtra" id = 'firstExtra' value = "">
    <input type = "hidden" name = "secondExtra" id = 'secondExtra' value = "">
      
  </div>
  <br>
   <label> Bowling Ball: </label>
  <div class="dropdown-select" >
  <select class="ball-dropdown" name="ball1">
  	<%@ page import="java.util.List" %>
  	<%@ page import= "revMetrix.db.model.Ball" %>
	<% 
            // Retrieve the objectList attribute from the request
            Object obj = request.getAttribute("balls");
            
            // Check if obj is an instance of ArrayList<Ball> before casting
            if (obj instanceof List) {
                List<Ball> ballList = (List<Ball>) obj;
                
                // Iterate over the ArrayList and generate options for the dropdown menu
                for (Ball ball : ballList) {
            %>
            <option value="<%= ball.getBallId() %>"><%= ball.getName() %></option>
            <% 
                } 
            } else {
            %>
            <option value="">No balls available</option>
            <% } %>
   
  </select>
  <select name="ball2" style="display: none;">
  	<%@ page import="java.util.List" %>
  	<%@ page import= "revMetrix.db.model.Ball" %>
	<% 
            // Retrieve the objectList attribute from the request
            if (obj instanceof List) {
            	List<Ball> ballList = (List<Ball>) obj;
                // Iterate over the ArrayList and generate options for the dropdown menu
                for (Ball ball : ballList) {
            %>
            <option value="<%= ball.getBallId() %>"><%= ball.getName() %></option>
            <% 
                } 
            } else {
            %>
            <option value="">No balls available</option>
            <% } %>
   
  </select>
  </div>
  <br>
</div>
<div class= "center2">
<label> Lane:</label>
<input class="lane" type="number" name = "lane" value = ${lane }>
</div>
<br>

</form>		      
        <br>
        <div class = "gameInfo">
        <div class = "center2">
        
        <form action="${pageContext.servletContext.contextPath}/game" method="post">
        <div class="dropdown-select">
 		<input class="swapbtn" type="Submit" name="submit" value="Swap Game">
		<select class="game-dropdown"name="Game">
		  	<%@ page import="java.util.ArrayList" %>
		  	<%@ page import= "revMetrix.db.model.Game" %>
			<% 
		            // Retrieve the objectList attribute from the request
		            Object games = request.getAttribute("games");
		            
		            // Check if obj is an instance of ArrayList<Ball> before casting
		            if (games instanceof List) {
		                ArrayList<Game> gameList = (ArrayList<Game>) games;
		                int i = 0;
		                // Iterate over the ArrayList and generate options for the dropdown menu
		                for (Game game : gameList) { i++;
		            %>
		            <option value="<%= game.getGameId() %>">Game <%= i+": "+game.getGameScore()+" "+game.getdoneBox() %></option>
		            <% 
		                } 
		            } else {
		            %>
		            <option value="">No Games available</option>
		            <% } %>
		   
		  </select>
		 
		  </div>
        
        </form>
        <form action="${pageContext.servletContext.contextPath}/game" method="post">
        <input class="newGamebtn" type="Submit" name="submit" value="New Game">
        <input type = "hidden" name = "firstRemaining"  value = "New">
        </form>
        </div>
        <div class = "center2">
        <form action="${pageContext.servletContext.contextPath}/game" method="post">
        <input class="remove-shot" type="Submit" name="submit" value="Remove Last Shot">
        <input type = "hidden" name = "firstRemaining"  value = "Rem">
        </form>
        </div>
        
        </div>
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
	  document.querySelector('.missbtn').style.backgroundColor = '#26acca';
	  document.querySelector('.foulbtn').style.backgroundColor = 'lightgrey';
	  document.querySelector('.strikebtn').style.backgroundColor = 'lightgrey';
	  document.querySelector('.sparebtn').style.backgroundColor = 'lightgrey';

    // gutter on first shot?
    if (shot == FIRST_SHOT) {
      // set up all pins
      setAllPinsStanding();
      first_Remaining = [0,1,2,3,4,5,6,7,8,9];
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
    first_Remaining.sort();
    second_Remaining.sort();
    var firstLoaction = document.getElementById('firstRemaining');
    var SecondLocation = document.getElementById('secondRemaining');

    firstLoaction.value = first_Remaining.join(",");
    SecondLocation.value = second_Remaining.join(",");

  }

  // set foul for current shot
  function setFoul() {
	  document.querySelector('.foulbtn').style.backgroundColor = '#26acca';
	  document.querySelector('.missbtn').style.backgroundColor = 'lightgrey';
	  document.querySelector('.strikebtn').style.backgroundColor = 'lightgrey';
	  document.querySelector('.sparebtn').style.backgroundColor = 'lightgrey';
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
	  document.querySelector('.sparebtn').style.backgroundColor = '#26acca';
	  document.querySelector('.foulbtn').style.backgroundColor = 'lightgrey';
	  document.querySelector('.strikebtn').style.backgroundColor = 'lightgrey';
	  document.querySelector('.missbtn').style.backgroundColor = 'lightgrey';
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
	  document.querySelector('.strikebtn').style.backgroundColor = '#26acca';
	  document.querySelector('.foulbtn').style.backgroundColor = 'lightgrey';
	  document.querySelector('.missbtn').style.backgroundColor = 'lightgrey';
	  document.querySelector('.sparebtn').style.backgroundColor = 'lightgrey';
    // clear all pins, and firstShot, then put 'X' in secondShot
    clearPins();

    // switch to first shot
    setFirstShot();

    // reset all counts;
    resetPinCounts();

    // 'X' is displayed in second square
    clearFirstShot();

    // set secondShot for a strike ('X')
    document.querySelector('.firstShot span').textContent = 'X';

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
  
  function Splits() {
	  var splitCount = [<c:forEach items="${split}" var="bool" varStatus="loop">
      <c:if test="${loop.index > 0}">,</c:if>
      ${bool}
  </c:forEach>];
      for(var i = 0; i<splitCount.length;i++){
    	  if(splitCount[i]==true){
    		  document.getElementById("split"+(i+1)).className = "split";
    	  }
    	  
      }
     
  }
  function LockOut() {
	  var LockedPins = [<c:forEach items="${locked}" var="bool" varStatus="loop">
      <c:if test="${loop.index > 0}">,</c:if>
      ${bool}
  </c:forEach>];
	  var flag = false;
	  var count = 0;
	  for(var i = 0; i<LockedPins.length;i++){
    	  if(LockedPins[i]==true){
    		  document.getElementById("pin"+i).removeAttribute("onclick");
    		  document.getElementById("pin"+i).className = "locked";
    		  flag = true;
    		  count++;
    	  }
    	  
      }
      if(flag){
    	  for(var i = 0; i<LockedPins.length;i++){
        	  if(LockedPins[i]==false){
        		  togglePin(document.getElementById("pin"+i),i);
        		  
        	  }
        	  
          }
      }
      
      if(count == 10){
    	  const nextShotButton = document.getElementById('nextShotButton');
    	  nextShotButton.disabled = true;
    	  nextShotButton.style.backgroundColor = '#ccc'; // Change background color to gray
    	  nextShotButton.style.color = '#666'; // Change text color to a darker shade of gray
    	  nextShotButton.style.cursor = 'not-allowed'; // Change cursor style to indicate not allowed
    	  
    	  
      }
     
  }
  function secondFrame(){
	 
		 
	  var secondFrame= [<c:forEach items="${secondFrame}" var="bool" varStatus="loop">
      <c:if test="${loop.index > 0}">,</c:if>
      ${bool}
  </c:forEach>];
	  
    	  if(secondFrame[0]==true){
    		  document.querySelector('.strike span').textContent = '/';
    	  }
    	  
      
	    
	  
  }
  function Startup(){
	  Splits();
	  LockOut();
	  secondFrame();
  }
  

</script>
</body>

</html>