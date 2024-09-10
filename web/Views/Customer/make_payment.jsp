
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <input type="hidden" id="payment_id" name="payment_id" value='${paymentId}'/>

    <div class="mb-3">
        <label for="amount" class="form-label">Amount:</label>
        <input type="text" class="form-control" id="amount" name="amount" value='${amount}' readonly/>
    </div>
    
    <div class="mb-3">
        <label for="card_number" class="form-label">Card Number:</label>
        <input type="text" class="form-control" id="card_number" name="card_number" required/>
    </div>
    <div class="mb-3">
        <label for="exp_month" class="form-label">Expiry Month:</label>
        <input type="text" class="form-control" id="exp_month" name="exp_month" required/>
    </div>
    <div class="mb-3">
        <label for="exp_year" class="form-label">Expiry Year:</label>
        <input type="text" class="form-control" id="exp_year" name="exp_year" required/>
    </div>
    <div class="mb-3">
        <label for="cvc" class="form-label">CVC:</label>
        <input type="text" class="form-control" id="cvc" name="cvc" required/>
    </div>
        
</div>
