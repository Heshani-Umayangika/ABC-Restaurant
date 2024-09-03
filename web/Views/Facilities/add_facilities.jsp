<%-- 
    Document   : add_test
    Created on : Mar 17, 2024, 6:17:10 PM
    Author     : Kelum
--%>


<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container"> 
    <div class="mb-3">
        <label for="facility_name" class="form-label">Name</label>
        <input type="text" class="form-control" id="facility_name" name="facility_name" required/>
    </div>

    <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <input type="text" class="form-control" id="description" name="description" required/>
    </div>

    <div class="mb-3">
        <label for="gender" class="form-label">Availability</label>
        <div class="btn-group" role="group" aria-label="Availability">
            <input type="radio" class="btn-check" name="availability_status" id="NA" autocomplete="off" value="false" checked required/>
            <label class="btn btn-outline-dark" for="NA">Unavailable</label>
            <input type="radio" class="btn-check" name="availability_status" id="A" autocomplete="off" value="true" required/>
            <label class="btn btn-outline-dark" for="A">Available</label>
        </div>
    </div>

</div>