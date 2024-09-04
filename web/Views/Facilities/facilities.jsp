
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="wrapper" style="width:100%;margin:0 auto;">
    &nbsp;  &nbsp;<button type="button" id="modal-add-facility" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="modal-add-facility"><i class="fa-solid fa-shop"></i>&nbsp; New</button>
    <div class="container">   
        <table border="1" id="abc_table" class="display" style="width:100%">
            <thead>
                <tr> 
                    <th>ID</th>  
                    <th>Name</th> 
                    <th>Description</th> 
                    <th>Availability</th> 
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>
                <jstl:forEach var="facility" items="${facilitiesList}" >
                    <tr>
                        <td> ${facility.facility_id} </td>
                        <td> ${facility.facility_name} </td>
                        <td> ${facility.description} </td>
                        <td> ${facility.availability_status} </td>
                        <td><button type="button" id="modal-edit-facility" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="${facility.facility_id}"><i class="fa-solid fa-marker"></i></button></td>
                        <td><button type="button" id="modal-delete-facility" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="${facility.facility_id}"><i class="fa-solid fa-trash"></i></button></td>
                    </tr>
                </jstl:forEach>
            </tbody>
        </table>
    </div>

</div> 