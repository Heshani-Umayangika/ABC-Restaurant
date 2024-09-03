<%-- 
    Document   : add_appointment
    Created on : Mar 17, 2024, 6:05:59 PM
    Author     : Kelum
--%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">

   <div class="mb-3">
        <label for="service_name" class="form-label">Name:</label>
        <input type="text" class="form-control" id="service_name" name="service_name" required/>
    </div>

    <div class="mb-3">
        <label for="description" class="form-label">Description:</label>
        <input type="text" class="form-control" id="description" name="description" required/>
    </div>

    <div class="mb-3">
        <label for="rate" class="form-label">Rate:</label>
        <input type="number" class="form-control" id="rate" name="rate" min="1" max="99999" required/>
    </div>
    
</div>
