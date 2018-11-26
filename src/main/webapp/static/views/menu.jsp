<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div id="logo">
    <img src="/images/arsenal.png" alt="Arsenal logo" width=70x height=70px />
    Arsenal <span style="color:white">Football</span> Club
    <div style="clear: both"></div>
</div>

<div id="menu">
    <div class="option"><a href="home" class="titlelink1">Strona główna</a></div>
    <div class="option"><a href="squad" class="titlelink1">Skład</a></div>
    <div class="option"><a href="fixtures" class="titlelink1">Terminarz</a></div>
    <div class="option"><a href="history" class="titlelink1">Historia</a></div>
    <div class="option"><a href="fans" class="titlelink1">Fani</a></div>
    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <div class="option">Admin</div>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_TRAINER')">
            <div class="option">Trener</div>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_FAN')">
            <div class="option">Kibic</div> 
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_PLAYER')">
                    <div class="option">Zawodnik</div>
        </sec:authorize>

    <div id="timer">

        

    </div>

    <div style="clear:both;"></div> <!-- czyszczenie, niezbędne -->
</div>