/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.RestaurantDatabaseUtilizer;
import Models.FacilitiesModel;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "FacilitiesController", urlPatterns = {"/Facilities"})
public class FacilitiesController extends HttpServlet {

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
                    getEditFacility(request, response);
                } else if ("Add".equals(page)) {
                    getAddFacility(request, response);
                } else if ("Delete".equals(page)) {
                    getDeleteFacility(request, response);
                } else {
                    getFacilitiesList(request, response);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    private void getEditFacility(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var facilityId = Integer.parseInt(request.getParameter("facilityId"));
        var facility = RestaurantDatabaseUtilizer.getFacility(facilityId);

        request.setAttribute("facility", facility);
        request.getRequestDispatcher("/Views/Facilities/edit_facilities.jsp").forward(request, response);
    }

    private void getAddFacility(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Facilities/add_facilities.jsp").forward(request, response);
    }

    private void getDeleteFacility(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var facilityId = Integer.parseInt(request.getParameter("facilityId"));
        request.setAttribute("facilityId", facilityId);
        request.getRequestDispatcher("/Views/Facilities/delete_facilities.jsp").forward(request, response);
    }

    private void getFacilitiesList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var facilitiesList = RestaurantDatabaseUtilizer.getFacilitiesList();
        request.setAttribute("facilitiesList", facilitiesList);
        request.getRequestDispatcher("/Views/Facilities/facilities.jsp").forward(request, response);
    }

//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var action = request.getParameter("action");
        if ("Delete".equals(action)) {
            deleteFacility(request, response);
        } else if ("Update".equals(action)) {
            updateFacility(request, response);
        } else {
            addFacility(request, response);
        }
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var facilityId = Integer.parseInt(request.getParameter("facilityId"));
        var isSuccess = RestaurantDatabaseUtilizer.deleteFacility(facilityId);
    }

    private void updateFacility(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var facility = new FacilitiesModel(Integer.parseInt(request.getParameter("facility_id")), request.getParameter("facility_name"), request.getParameter("description"), Boolean.parseBoolean(request.getParameter("availability_status")));
        var isSuccess = RestaurantDatabaseUtilizer.updateFacility(facility);
    }

    private void addFacility(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("");
      var facility = new FacilitiesModel(0, request.getParameter("facility_name"), request.getParameter("description"), Boolean.parseBoolean(request.getParameter("availability_status")));
        var isSuccess = RestaurantDatabaseUtilizer.addFacility(facility);
    }

}
