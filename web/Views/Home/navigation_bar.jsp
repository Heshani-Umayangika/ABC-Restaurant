<%-- 
    Document   : navigation_bar
    Created on : Mar 17, 2024, 6:11:18 PM
    Author     : Kelum
--%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="top-bar bg-primary">
    <div></div>
    <span class="logout-btn" id="signout"> Sign Out </span>
</div>

<div class="side-nav bg-primary">
    <jstl:if test="${'Administrator' eq sessionScope.authType}">
        <a href="/ABC_Restaurant/Dashboard" >
            <i class="fa-solid fa-gauge-high"></i>
            <span class="ms-4">Dashboard</span> 
        </a>
        <a href="/ABC_Restaurant/Items_Services">
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
            <i class="fa-solid fa-calendar-check"></i> 
            <span class="ms-4">Reservations</span> 
        </a>
        <a href="/ABC_Restaurant/Facilities" id="default">
            <i class="fa-solid fa-shop"></i> 
            <span class="ms-4">Facilities</span> 
        </a>
        <a href="/ABC_Restaurant/Gallery">
            <i class="fa-solid fa-photo-film"></i> 
            <span class="ms-4">Gallery</span> 
        </a>
        <a href="/ABC_Restaurant/Payments">
            <i class="fa-solid fa-sack-dollar"></i> 
            <span class="ms-4">Payments</span> 
        </a>
        <a href="/ABC_Restaurant/Inquiries">
            <i class="fa-solid fa-headset"></i> 
            <span class="ms-4">Inquiries</span> 
        </a>
        <a href="/ABC_Restaurant/Report">
            <i class="fa-solid fa-chart-line"></i> 
            <span class="ms-4">Reports</span> 
        </a>
    </jstl:if>

    <jstl:if test="${'Staff' eq sessionScope.authType}">
        <a href="/ABC_Restaurant/Patients" id="default">
            <i class="fa-solid fa-users"></i> 
            <span class="ms-4">Patients</span> 
        </a>
        <a href="/ABC_Restaurant/Appointments">
            <i class="fa-solid fa-calendar-check"></i> 
            <span class="ms-4">Appointments</span> 
        </a>
        <a href="/ABC_Restaurant/Payments">
            <i class="fa-solid fa-file-invoice-dollar"></i> 
            <span class="ms-4">Payments</span> 
        </a>
    </jstl:if>

    <jstl:if test="${'Customer' eq sessionScope.authType}">
        <a href="/ABC_Restaurant/Technician" id="default">
            <i class="fa-solid fa-calendar-check"></i> 
            <span class="ms-4">Appointments</span> 
        </a>
    </jstl:if>

    <jstl:if test="${'ptnt' eq sessionScope.authType}">
        <a href="/ABC_Restaurant/Visitor" id="default">
            <i class="fa-solid fa-file-medical"></i> 
            <span class="ms-4">My Reports</span>
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