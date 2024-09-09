<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="top-bar bg-primary">
    <div></div>
    <span class="logout-btn" id="signout"> Sign Out </span>
</div>

<div class="side-nav bg-primary">
    <jstl:if test="${'Administrator' eq sessionScope.authType}">
        <a href="/ABC_Restaurant/Dashboard">
            <i class="fa-solid fa-gauge-high"></i>
            <span class="ms-4">Dashboard</span> 
        </a>

        <a href="/ABC_Restaurant/Services">
            <i class="fa-solid fa-burger"></i> 
            <span class="ms-4">Items & Services</span> 
        </a>

        <a href="/ABC_Restaurant/Users">
            <i class="fa-solid fa-users"></i> 
            <span class="ms-4">Users</span> 
        </a>

        <a href="/ABC_Restaurant/Offers">
            <i class="fa-solid fa-gift"></i> 
            <span class="ms-4">Offers</span> 
        </a>

        <a href="/ABC_Restaurant/Reservations">
            <i class="fa-solid fa-calendar-day"></i> 
            <span class="ms-4">Reservations</span> 
        </a>

        <a href="/ABC_Restaurant/Facilities">
            <i class="fa-solid fa-shop"></i> 
            <span class="ms-4">Facilities</span> 
        </a>

        <a href="/ABC_Restaurant/Payments">
            <i class="fa-solid fa-sack-dollar"></i> 
            <span class="ms-4">Payments</span> 
        </a>

        <a href="/ABC_Restaurant/Inquiries" id="default">
            <i class="fa-solid fa-headset"></i> 
            <span class="ms-4">Inquiries</span> 
        </a>

        <a href="/ABC_Restaurant/Gallery">
            <i class="fa-solid fa-photo-film"></i> 
            <span class="ms-4">Gallery</span> 
        </a>
    </jstl:if>

    <jstl:if test="${'Staff' eq sessionScope.authType}">
        <a href="/ABC_Restaurant/Reservations" id="default">
            <i class="fa-solid fa-calendar-day"></i> 
            <span class="ms-4">Reservations</span> 
        </a>     
        <a href="/ABC_Restaurant/Offers">
            <i class="fa-solid fa-gift"></i> 
            <span class="ms-4">Offers</span> 
        </a>

        <a href="/ABC_Restaurant/Facilities">
            <i class="fa-solid fa-shop"></i> 
            <span class="ms-4">Facilities</span> 
        </a>

        <a href="/ABC_Restaurant/Payments" id="default">
            <i class="fa-solid fa-sack-dollar"></i> 
            <span class="ms-4">Payments</span> 
        </a>
    </jstl:if>

    <jstl:if test="${'Customer' eq sessionScope.authType}">
        <a href="/ABC_Restaurant/MyReservations"  id="default">
            <i class="fa-solid fa-calendar-day"></i> 
            <span class="ms-4">Reservations</span> 
        </a>  
        <a href="/ABC_Restaurant/MyInquiries">
            <i class="fa-solid fa-envelope"></i> 
            <span class="ms-4">Inquiries</span> 
        </a>

    </jstl:if>

    <div class="side-nav-bottom">
        <p>
            ${sessionScope.authType}
            <br/>
            ${sessionScope.userName}
        </p>
        <span id="clock" class="clock">00:00:00</span>
    </div>
</div>
<button class="toggle-btn btn btn-primary"><i class="fas fa-bars"></i></button>