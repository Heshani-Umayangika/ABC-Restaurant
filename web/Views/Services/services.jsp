
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="wrapper" style="width:100%;margin:0 auto;">

    &nbsp;  &nbsp;<button type="button" id="modal-add-services" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id=""><i class="fa-solid fa-calendar-plus"></i>&nbsp; New</button>

    <div class="container">   
        <table border="1" id="abc_table" class="display" style="width:100%">
            <thead>
                <tr> 
                    <th>ID</th>  
                    <th>Name</th> 
                    <th>Description</th> 
                    <th>Rate</th> 
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>
                <jstl:forEach var="items" items="${servicesList}" >
                    <tr>
                        <td> ${items.service_id} </td>
                        <td> ${items.service_name} </td>
                        <td> ${items.description} </td>
                        <td> ${items.rate} </td>
                        <td>
                            <button type="button" id="modal-edit-services" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="${items.service_id}"> <i class="fa-solid fa-calendar-day"></i>&nbsp;</button>
                        </td>

                        <td>
                            <button type="button" id="modal-delete-services" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="${items.service_id}"><i class="fa-solid fa-calendar-minus"></i> &nbsp;</button>
                        </td>

                    </tr>
                </jstl:forEach>
            </tbody>
        </table>
    </div>

</div> 