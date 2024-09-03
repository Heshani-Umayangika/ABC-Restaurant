<%-- 
    Document   : edit_patient
    Created on : Mar 17, 2024, 6:13:28 PM
    Author     : Kelum
--%>


<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="container">
    <input type="hidden" class="form-control" id="offer_id" name="offer_id" value='${offer.offer_id}'/>
    
     <div class="mb-3">
        <label for="offer_name" class="form-label">Name:</label>
        <input type="text" class="form-control" id="offer_name" name="offer_name" value='${offer.offer_name}' required/>
    </div>
    
    <div class="mb-3">
        <label for="description" class="form-label">Description:</label>
        <input type="text" class="form-control" id="description" name="description" value='${offer.description}' required/>
    </div>
    
    <div class="mb-3">
        <label for="start_date" class="form-label">Start:</label>
        <input type="date" class="form-control" id="start_date" name="start_date" value='${offer.start_date}' required/>
    </div>
    
    <div class="mb-3">
        <label for="end_date" class="form-label">End:</label>
        <input type="date" class="form-control" id="end_date" name="end_date" value='${offer.end_date}' required/>
    </div>
    
    <div class="mb-3">
        <label for="discount_percentage" class="form-label">Discount Percentage:</label>
        <input type="number" class="form-control" id="discount_percentage" name="discount_percentage" min="1" max="99" value='${offer.discount_percentage}' required/>
    </div>
</div>