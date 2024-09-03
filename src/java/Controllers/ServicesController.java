/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.DatabaseUtilizer;
import Models.Restaurant.FacilitiesModel;
import Models.Restaurant.ServicesModel;
import Models.Restaurant.UsersModel;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashSet;

@WebServlet(name = "ServicesController", urlPatterns = {"/Services"})
public class ServicesController extends HttpServlet {

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
                if ("Edit".equals(page)) {
                    getEditService(request, response);
                } else if ("Add".equals(page)) {
                    getAddService(request, response);
                } else if ("Delete".equals(page)) {
                    getDeleteService(request, response);
                } else {
                    getServicesList(request, response);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    private void getEditService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var serviceId = Integer.parseInt(request.getParameter("serviceId"));
        var service = DatabaseUtilizer.getService(serviceId);

        request.setAttribute("service", service);
        request.getRequestDispatcher("/Views/Services/edit_services.jsp").forward(request, response);
    }

    private void getAddService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Services/add_services.jsp").forward(request, response);
    }

    private void getDeleteService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var serviceId = Integer.parseInt(request.getParameter("serviceId"));
        request.setAttribute("serviceId", serviceId);
        request.getRequestDispatcher("/Views/Services/delete_services.jsp").forward(request, response);
    }

    private void getServicesList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var servicesList = DatabaseUtilizer.getServicesList();
        request.setAttribute("servicesList", servicesList);
        request.getRequestDispatcher("/Views/Services/services.jsp").forward(request, response);
    }

//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var action = request.getParameter("action");
        if ("Delete".equals(action)) {
            deleteService(request, response);
        } else if ("Update".equals(action)) {
            updateService(request, response);
        } else {
            addService(request, response);
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var serviceId = Integer.parseInt(request.getParameter("serviceId"));
        var isSuccess = DatabaseUtilizer.deleteService(serviceId);
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      var service = new ServicesModel(Integer.parseInt(request.getParameter("service_id")), request.getParameter("service_name"), request.getParameter("description"), new BigDecimal(request.getParameter("rate")));
        var isSuccess = DatabaseUtilizer.updateService(service);
    }

    private void addService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      var service = new ServicesModel(0, request.getParameter("service_name"), request.getParameter("description"), new BigDecimal(request.getParameter("rate")));
        var isSuccess = DatabaseUtilizer.addService(service);
    }

}
