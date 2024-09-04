<%-- 
    Document   : edit_test
    Created on : Mar 17, 2024, 6:17:41 PM
    Author     : Kelum
--%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container"> 
    <input type="hidden" class="form-control" id="test_id" name="facility_id" value='${facility.facility_id}' required/>
    
    <div class="mb-3">
        <label for="facility_name" class="form-label">Name:</label>
        <input type="text" class="form-control" id="facility_name" name="facility_name" value='${facility.facility_name}'required/>
    </div>

    <div class="mb-3">
        <label for="description" class="form-label">Description:</label>
        <input type="text" class="form-control" id="description" name="description" value='${facility.description}'required/>
    </div>

    <div class="mb-3">
        <label for="gender" class="form-label">Availability:</label>
        <div class="btn-group" role="group" aria-label="Availability">
            <input type="radio" class="btn-check" name="availability_status" id="NA" autocomplete="off" value="false" ${facility.availability_status == 'false' ? 'checked' : ''} required/>
            <label class="btn btn-outline-dark" for="NA">Unavailable</label>
            <input type="radio" class="btn-check" name="availability_status" id="A" autocomplete="off" value="true" ${facility.availability_status == 'true' ? 'checked' : ''} required/>
            <label class="btn btn-outline-dark" for="A">Available</label>
        </div>
    </div>
</div>

