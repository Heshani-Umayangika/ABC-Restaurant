
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="wrapper" style="width:100%;margin:0 auto;">
    &nbsp;  &nbsp;<button type="button" id="modal-add-my-reservations" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id=""><i class="fa-solid fa-calendar-plus"></i>&nbsp; New</button>
    <div class="container"> 
        <table border="1" id="abc_table" class="display" style="width:100%">
            <thead>
                <tr>  
                    <th>ID</th>
                    <th>Date</th> 
                    <th>Time</th>
                    <th>People</th>
                    <th>Service</th>
                    <th>Type</th>
                    <th>Status</th>
                    <th>Special Requests</th>
                    <th>Delete</th>
                </tr>

            </thead>

            <tbody>

                <jstl:forEach var="reservation" items="${userReservationsList}">           
                    <tr>    
                        <td>${reservation.reservation_id}</td>
                        <td>${reservation.reservation_date}</td>
                        <td>${reservation.reservation_time}</td>
                        <td>${reservation.number_of_people}</td>
                        <td>${reservation.service_name}</td>
                        <td>${reservation.service_type eq 'true'? 'Dine-In':'Delivery'}</td>
                        <td>${reservation.status}</td>
                        <td>${reservation.special_requests}</td>
                        <td><button type="button" id="modal-delete-my-reservations" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="${reservation.reservation_id}"><i class="fa-solid fa-calendar-xmark"></i></button></td>
                    </tr>
                </jstl:forEach>

            </tbody>
        </table>
    </div>

</div> 