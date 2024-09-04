
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">

    <div class="mb-3">
        <label for="customer_id" class="form-label">Customer:</label>
        <select id="customer_id" name="customer_id" class="form-control" required>
            <jstl:forEach var="items" items="${customersList}" >
                <option value='${items.user_id}'>${items.customer_name}</option>
            </jstl:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label for="reservation_date" class="form-label">Reservation Date:</label>
        <input type="date" class="form-control" id="reservation_date" name="reservation_date" required/>
    </div>
    <div class="mb-3">
        <label for="reservation_time" class="form-label">Reservation Time:</label>
        <input type="time" class="form-control" id="reservation_time" name="reservation_time" required/>
    </div>
    <div class="mb-3">
        <label for="number_of_people" class="form-label">Number of People:</label>
        <input type="number" class="form-control" id="number_of_people" name="number_of_people"  min="1" max="999" maxlength="3" required/>
    </div>

    <div class="mb-3">
        <label for="service_type" class="form-label">Service Type:</label>
        <div class="btn-group" role="group" aria-label="Availability">
            <input type="radio" class="btn-check" name="service_type" id="dine_in" autocomplete="off" value="false" checked required/>
            <label class="btn btn-outline-dark" for="dine_in">Dine-In</label>
            <input type="radio" class="btn-check" name="service_type" id="delivery" autocomplete="off" value="true" required/>
            <label class="btn btn-outline-dark" for="delivery">Delivery</label>
        </div>
    </div>

    <div class="mb-3">
        <label for="status" class="form-label">Status:</label>
        <select id="status" name="status" class="form-control" required>
            <option value="Pending">Pending</option>
            <option value="Confirmed">Confirmed</option>
            <option value="Cancelled">Cancelled</option> 
        </select>
    </div>
    <div class="mb-3">
        <label for="special_requests" class="form-label">Special Requests:</label>
        <textarea class="form-control" id="special_requests" name="special_requests" required></textarea>
    </div>
</div>