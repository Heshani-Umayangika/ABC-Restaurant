
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="wrapper" style="width:100%;margin:0 auto;">
    &nbsp;  &nbsp;<button type="button" id="modal-add-myInquiries" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id=""><i class="fa-solid fa-envelope-open"></i>&nbsp; New</button>
    <div class="container"> 
        <table border="1" id="abc_table" class="display" style="width:100%">
            <thead>
                <tr>  
                    <th>Date & Time</th>
                    <th>Subject</th> 
                    <th>Message</th>
                    <th>Delete</th>
                </tr>

            </thead>

            <tbody>

                <jstl:forEach var="inquiry" items="${userInquiriesList}">           
                    <tr>    
                        <td>${inquiry.submitted_at}</td>
                        <td>${inquiry.subject}</td>
                        <td>${inquiry.message}</td>
                        <td><button type="button" id="modal-delete-myInquiries" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modal-popup-window" data-test-id="${inquiry.inquiry_id}"><i class="fa-solid fa-trash"></i></button></td>
                    </tr>
                </jstl:forEach>

            </tbody>
        </table>
    </div>

</div> 