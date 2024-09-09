/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.RestaurantDatabaseUtilizer;
import Models.Inherited.InquiriesModel;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MyInquiriesController", urlPatterns = {"/MyInquiries"})
public class MyInquiriesController extends HttpServlet {

//Get Methods
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var session = request.getSession(false);
        if (session != null) {
            String authType = (String) session.getAttribute("authType");
            if (authType == null) {
                response.sendRedirect("/ABC_Restaurant/Login?page=signin");
            } else {
                var page = request.getParameter("page");
                if ("Add".equals(page)) {
                    getAddOffers(request, response);
                } else if ("Delete".equals(page)) {
                    getDeleteOffers(request, response);
                } else {
                    int userId = (int) session.getAttribute("userId");
                    getMyInquiriesList(request, response, userId);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }


    private void getAddOffers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Customer/add_my_inquiries.jsp").forward(request, response);
    }

    private void getDeleteOffers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var inquiryId = Integer.parseInt(request.getParameter("inquiryId"));
        request.setAttribute("inquiryId", inquiryId);
        request.getRequestDispatcher("/Views/Customer/delete_my_inquiries.jsp").forward(request, response);
    }

    private void getMyInquiriesList(HttpServletRequest request, HttpServletResponse response, int userId)
            throws ServletException, IOException {
        var userInquiriesList = RestaurantDatabaseUtilizer.getUserInquiriesList(userId);
        request.setAttribute("userInquiriesList", userInquiriesList);
        request.getRequestDispatcher("/Views/Customer/my_inquiries.jsp").forward(request, response);
    }

//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var action = request.getParameter("action");
        if ("Delete".equals(action)) {
            deleteMyInquiry(request, response);
        } else {
            addMyInquiry(request, response);
        }
    }

    private void deleteMyInquiry(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var inquiryId = Integer.parseInt(request.getParameter("inquiryId"));
        var isSuccess = RestaurantDatabaseUtilizer.deleteInquiry(inquiryId);
    }


    private void addMyInquiry(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var session = request.getSession(false);
        int userId = (int) session.getAttribute("userId");
        var inquiry = new InquiriesModel(0,userId , request.getParameter("subject"), request.getParameter("message"),""); 
        var isSuccess = RestaurantDatabaseUtilizer.addInquiry(inquiry);
    }

}
