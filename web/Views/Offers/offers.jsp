
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="wrapper" style="width:100%;margin:0 auto;">

    &nbsp;  &nbsp;<button type="button" id="modal-add-offers" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id=""><i class="fa-solid fa-gift"></i>&nbsp; New</button>

    <div class="container"> 
        <table border="1" id="abc_table" class="display" style="width:100%">
            <thead>
                <tr> 
                    <th>ID</th>  
                    <th>Name</th> 
                    <th>Description</th> 
                    <th>Start</th> 
                    <th>End</th> 
                    <th>Discount</th> 
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>
            </thead>

            <tbody>
                <jstl:forEach var="offer" items="${offersList}" >
                    <tr>
                        <td> ${offer.offer_id} </td>
                        <td> ${offer.offer_name}</td>
                        <td> ${offer.description}</td>
                        <td> ${offer.start_date} </td>
                        <td> ${offer.end_date} </td>
                        <td> ${offer.discount_percentage}%</td>
                        <td><button type="button" id="modal-edit-offers" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="${offer.offer_id}"><i class="fa-solid fa-marker"></i></button></td>
                        <td><button type="button" id="modal-delete-offers" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="${offer.offer_id}"><i class="fa-solid fa-trash"></i></button></td>
                    </tr>
                </jstl:forEach>
            </tbody>
        </table>
    </div>

</div> 
