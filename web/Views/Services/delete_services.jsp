<%-- 
    Document   : delete_appointment
    Created on : Mar 17, 2024, 6:06:21 PM
    Author     : Kelum
--%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<p>Deleting the record! <p class="text-danger"> Service ID :  ${serviceId} </p> This action will remove it permanently. Proceed with caution. </p>

<input type="hidden" class="form-control" id="serviceId" name="serviceId" value='${serviceId}'/>