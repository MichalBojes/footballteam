<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>



<head>
   	<link rel="stylesheet" href="/css/style_arsenal.css" type="text/css"/> 
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
	
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title> Arsenal F.C - strona domowa </title>

    <meta name="describtion" content="Tutaj dowiesz się wszystkiego o klubie Arsenal - aktualności, terminarz, historia i wiele, wiele więcej." />
    <meta name="keywords" content="Arsenal,piłka nożna, piłkarze, mecze, terminarz"/>


    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    
    <script src="/js/timer.js"></script> 



</head>


<body onload="start()">
    


<div id="container">
    <div id="photos">
        <div id="player"></div>
        <div id="team">
           <img src="/images/team1.jpg" width="230px" height=300px />
        </div>
     
    </div>
    <div id="main">
        <div id="logo">
           Arsenal Football Club
        </div>

        <div id="menu">
            <div class="option">Strona główna </div> 
            <div class="option">Skład</div>
            <div class="option">Terminarz</div> 
            <div class="option">Władze klubu </div> 
            <div class="option">Historia</div> 
            <div class="option">Fani</div> 
            <div id="timer">
            
            </div>

            
            <div style="clear:both;"></div> <!-- czyszczenie, niezbędne -->
        </div>

        <div id="topbar">
            <div id="topbarL">
                <img src="/images/arsenal.png" width="130px" height="130px"/>
            </div>

            <div id="topbarR">
            <span class="bigtitle">O Arsenalu słów kilka</span>
            <div style="height:15px"></div>
            Czerwień, biel i armaty - idealny zestaw dla każdego fana Arsenalu. <br/>
            Może będzie pasować i dla Ciebie? Przekonaj się, że Arsenal to więcej niż tylko klub ;)

             </div>
             
        

             <div style="clear:both;"></div>   
         </div>

        <div id="sidebar">
    
            <div class="optionL">Strona główna </div> 
            <div class="optionL">Skład</div>
            <div class="optionL">Terminarz</div> 
            <div class="optionL">Władze klubu </div> 
            <div class="optionL">Historia</div> 
            <div class="optionL">Fani</div> 
            <div style="clear:both;"></div> <!-- czyszczenie, niezbędne -->
            

        </div>

        <div id="content">
            
            <span class="bigtitle">Aktualności</span>
            <div class="dottedline"></div>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a mi odio. Cras molestie tellus interdum ullamcorper porttitor. 
            Sed eu arcu diam. Morbi venenatis pharetra eros, at vehicula leo porttitor eu. Phasellus iaculis ac nisi ut vehicula. 
            Morbi vulputate tortor eu odio scelerisque posuere. Pellentesque in consequat diam, ac bibendum ante. In sagittis,
             erat at pulvinar egestas, sapien dui laoreet est, vel blandit lectus nisl ac lacus.

             <br/>
             Vestibulum posuere nibh vitae sem faucibus mattis. Donec rhoncus porttitor sagittis. Ut id tempus odio. 
             Fusce sed nisl dignissim, pellentesque ligula vitae, rutrum est.
              Phasellus sit amet velit ac dui facilisis malesuada. Nullam at congue velit. 
              Integer bibendum consequat nisl, ut malesuada nulla rhoncus eget
        </div>

        <div id="footer">
            Poznaj Arsenal! &copy; Prawa zastrzeżone!
        </div>
        
    </div>
    <div id="reje">
        <a href="login">Zaloguj się</a>
		<a href="register">Zarejestruj się</a>
		<a href="logout">Wyloguj</a>
		<a href="admin">Administracja</a>
    </div>
    <div id="czat">
        tu bedzie czat
    </div>
    </div>
   

</body>
