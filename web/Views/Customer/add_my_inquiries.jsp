
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">

   <div class="mb-3">
        <label for="service_name" class="form-label">Subject:</label>
        <input type="text" class="form-control" id="subject" name="subject" required/>
    </div>

    <div class="mb-3">
        <label for="description" class="form-label">Message:</label>
        <textarea type="text" class="form-control" id="message" name="message" rows="4"> </textarea>
    </div>
    
</div>
