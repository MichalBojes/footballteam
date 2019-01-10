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
    <sec:authorize access="hasAnyAuthority('ROLE_TRAINER','ROLE_PLAYER')">
    <div class="option"><a href="trainings" class="titlelink1">Treningi</a></div>
    </sec:authorize>
    <div class="option"><a href="history" class="titlelink1">Historia</a></div>
    
    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <div class="option"><a href="admin" class="titlelink1">Admin</a></div>
    </sec:authorize>
   

    <div id="timer">

        

    </div>

    <div style="clear:both;"></div> <!-- czyszczenie, niezbędne -->
</div>