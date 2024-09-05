
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">

    <input type="hidden" id="payment_id" name="payment_id" value='${payment.payment_id}'/>
    
    <div class="mb-3">
        <label for="payment_method" class="form-label">Payment Method</label>
        <select class="form-select" id="payment_method" name="payment_method" required>
            <option value="" selected disabled>Select Payment Method</option>
            <option value="Cash" ${payment.payment_method == 'Cash' ? 'selected' : ''}>Cash</option>
            <option value="Card" ${payment.payment_method == 'Card' ? 'selected' : ''}>Card</option>
            <option value="Cheque" ${payment.payment_method == 'Cheque' ? 'selected' : ''}>Cheque</option>
            <option value="Other" ${payment.payment_method == 'Other' ? 'selected' : ''}>Other</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="payment_status" class="form-label">Payment Status</label>
        <div class="form-check form-switch">
            <input class="form-check-input" type="checkbox" id="payment_status" name="payment_status" ${Boolean(payment.payment_status) ? 'checked' : ''}/>
            <label class="form-check-label" for="payment_status">Paid</label>
        </div>
    </div>

</div>
