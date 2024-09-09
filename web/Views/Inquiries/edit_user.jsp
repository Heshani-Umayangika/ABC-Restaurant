<%-- 
    Document   : edit_user
    Created on : Mar 17, 2024, 6:18:36 PM
    Author     : Kelum
--%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<input type="hidden" class="form-control" id="user_id" name="user_id" value='${user.user_id}'/>
<div class="container">


    <div class="mb-3">
        <label for="first_name" class="form-label">First Name:</label>
        <input type="text" class="form-control" id="first_name" name="first_name" value='${user.first_name}' required/>
    </div>

    <div class="mb-3">
        <label for="last_name" class="form-label">Last Name:</label>
        <input type="text" class="form-control" id="last_name" name="last_name" value='${user.last_name}' required/>
    </div>

    <div class="mb-3">
        <label for="phone_number" class="form-label">Phone Number:</label>
        <input type="text" class="form-control" id="phone_number" name="phone_number" value='${user.phone_number}' maxlength="12" required/>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="email" class="form-control" id="email" name="email" value='${user.email}' required/>
    </div>

    <div class="mb-3">
        <label for="address" class="form-label">Address:</label>
        <input type="text" class="form-control" id="address" name="address" value='${user.address}' required/>
    </div>

    <div class="mb-3">
        <label for="user_type" class="form-label">Role:</label>
        <select id="user_type" name="user_type" class="form-control" required>

            <option value="Customer" <jstl:if test="${user.user_type eq 'Customer'}">selected</jstl:if>>Customer</option>

                <option value="Staff" <jstl:if test="${user.user_type eq 'Staff'}">selected</jstl:if>>Staff</option>

                <option value="Administrator" <jstl:if test="${user.user_type eq 'Administrator'}">selected</jstl:if>>Administrator</option>

        </select>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password:</label>
        <input type="password" class="form-control" id="password" name="password" value='${user.password}' required/>
    </div>

</div>