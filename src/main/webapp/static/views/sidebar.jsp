<%@ page session="false" isELIgnored="false" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div id="sidebar">
    
    <div class="optionL"><a href="home" class="titlelink2">Strona główna</a></div> 
    <div class="optionL"><a href="squad" class="titlelink2">Skład</a></div>
    <div class="optionL"><a href="fixtures" class="titlelink2">Terminarz</a></div> 
    <div class="optionL"><a href="history" class="titlelink2">Historia</a></div> 
   
    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
            <div class="optionL"><a href="admin" class="titlelink2">Admin</a></div>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_TRAINER')">
            <div class="optionL"><a href="trainer" class="titlelink2">Trener</a></div>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_FAN')">
            <div class="optionL"><a href="fans_gallery" class="titlelink2">Kibic</a></div> 
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_PLAYER')">
                    <div class="optionL"><a href="player" class="titlelink2">Zawodnik</a></div>
    </sec:authorize>


    <div style="clear:both;"></div> <!-- czyszczenie, niezbędne -->
    

</div>
