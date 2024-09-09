<%-- 
    Document   : add_user
    Created on : Mar 17, 2024, 6:18:16 PM
    Author     : Kelum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">

    <div class="mb-3">
        <label for="first_name" class="form-label">First Name:</label>
        <input type="text" class="form-control" id="first_name" name="first_name" required/>
    </div>
    <div class="mb-3">
        <label for="last_name" class="form-label">Last Name:</label>
        <input type="text" class="form-control" id="last_name" name="last_name" required/>
    </div>
    <div class="mb-3">
        <label for="phone_number" class="form-label">Phone Number:</label>
        <input type="text" class="form-control" id="phone_number" name="phone_number" maxlength="12" required/>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="email" class="form-control" id="email" name="email" required/>
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">Address:</label>
        <input type="text" class="form-control" id="address" name="address" required/>
    </div>

    <div class="mb-3">
        <label for="user_type" class="form-label">Role:</label>
        <select id="user_type" name="user_type" class="form-control" required>
            <option value="Customer">Customer</option>
            <option value="Staff">Staff</option>
            <option value="Administrator">Administrator</option>
        </select>
    </div>
 <div class="mb-3">
        <label for="password" class="form-label">Password:</label>
        <input type="password" class="form-control" id="password" name="password" required/>
 </div>
</div>