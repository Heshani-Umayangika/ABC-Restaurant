/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.RestaurantDatabaseUtilizer;
import Models.Inherited.ReservationsModel;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MyReservationsController", urlPatterns = {"/MyReservations"})
public class MyReservationsController extends HttpServlet {

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
                    getAddMyReservations(request, response);
                } else if ("Delete".equals(page)) {
                    getDeleteMyReservations(request, response);
                } else {
                    int userId = (int) session.getAttribute("userId");
                    getMyReservationsList(request, response, userId);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    private void getAddMyReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                var customersList = RestaurantDatabaseUtilizer.getCustomersDropdownList();
        var servicesList = RestaurantDatabaseUtilizer.getServicesList();
        request.setAttribute("servicesList", servicesList);
        request.getRequestDispatcher("/Views/Customer/add_my_reservation.jsp").forward(request, response);
    }

    private void getDeleteMyReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var reservationId = Integer.parseInt(request.getParameter("reservationId"));
        request.setAttribute("reservationId", reservationId);
        request.getRequestDispatcher("/Views/Customer/delete_my_reservation.jsp").forward(request, response);
    }

    private void getMyReservationsList(HttpServletRequest request, HttpServletResponse response, int userId)
            throws ServletException, IOException {
        System.out.println(userId);
        var userReservationsList = RestaurantDatabaseUtilizer.getUserReservationsList(userId);
        System.out.println(userReservationsList!=null);
        request.setAttribute("userReservationsList", userReservationsList);
        request.getRequestDispatcher("/Views/Customer/my_reservations.jsp").forward(request, response);
    }

//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var action = request.getParameter("action");
        if ("Delete".equals(action)) {
            deleteMyReservations(request, response);
        } else {
            addMyReservations(request, response);
        }
    }

    private void deleteMyReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var reservationId = Integer.parseInt(request.getParameter("reservationId"));
        var isSuccess = RestaurantDatabaseUtilizer.deleteReservation(reservationId);
    }

    private void addMyReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                var session = request.getSession(false);
        int userId = (int) session.getAttribute("userId");
        var reservation = new ReservationsModel(
                0,
                userId,
                request.getParameter("reservation_date"),
                request.getParameter("reservation_time"),
                Integer.parseInt(request.getParameter("number_of_people")),
                Integer.parseInt(request.getParameter("service_id")),
                Boolean.parseBoolean(request.getParameter("service_type")),
               "Confirmed",
                request.getParameter("special_requests"));
        var isSuccess = RestaurantDatabaseUtilizer.addReservation(reservation);
    }

}
