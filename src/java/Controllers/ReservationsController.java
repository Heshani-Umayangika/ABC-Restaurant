/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.DatabaseUtilizer;
import Models.FacilitiesModel;
import Models.OffersModel;
import Models.ReservationsModel;
import Models.ServicesModel;
import Models.UsersModel;
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

@WebServlet(name = "ReservationsController", urlPatterns = {"/Reservations"})
public class ReservationsController extends HttpServlet {

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
                    getEditReservations(request, response);
                } else if ("Add".equals(page)) {
                    getAddReservations(request, response);
                } else if ("Delete".equals(page)) {
                    getDeleteReservations(request, response);
                } else if ("Info".equals(page)) {
                    getInfoReservations(request, response);
                }else {
                    getReservationsList(request, response);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    private void getEditReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var reservationId = Integer.parseInt(request.getParameter("reservationId"));
        var reservation = DatabaseUtilizer.getReservation(reservationId);
        var customersList = DatabaseUtilizer.getCustomersDropdownList();
        request.setAttribute("customersList", customersList);
        request.setAttribute("reservation", reservation);
        request.getRequestDispatcher("/Views/Reservations/edit_reservation.jsp").forward(request, response);
    }

    private void getAddReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var customersList = DatabaseUtilizer.getCustomersDropdownList();
        request.setAttribute("customersList", customersList);
        request.getRequestDispatcher("/Views/Reservations/add_reservation.jsp").forward(request, response);
    }

    private void getDeleteReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var reservationId = Integer.parseInt(request.getParameter("reservationId"));
        request.setAttribute("reservationId", reservationId);
        request.getRequestDispatcher("/Views/Reservations/delete_reservation.jsp").forward(request, response);
    }

    private void getReservationsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var reservationsList = DatabaseUtilizer.getReservationsList();
        request.setAttribute("reservationsList", reservationsList);
        request.getRequestDispatcher("/Views/Reservations/reservations.jsp").forward(request, response);
    }

    private void getInfoReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var customerId = Integer.parseInt(request.getParameter("customerId"));
        var user = DatabaseUtilizer.getUser(customerId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/Views/Reservations/view_customer.jsp").forward(request, response);
    }
//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var action = request.getParameter("action");
        if ("Delete".equals(action)) {
            deleteReservations(request, response);
        } else if ("Update".equals(action)) {
            updateReservations(request, response);
        } else {
            addReservations(request, response);
        }
    }

    private void deleteReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var reservationId = Integer.parseInt(request.getParameter("reservationId"));
        System.out.println(reservationId);
        var isSuccess = DatabaseUtilizer.deleteReservation(reservationId);
    }

    private void updateReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var reservation = new ReservationsModel(
                Integer.parseInt(request.getParameter("reservation_id")),
                Integer.parseInt(request.getParameter("customer_id")),
                request.getParameter("reservation_date"),
                request.getParameter("reservation_time"),
                Integer.parseInt(request.getParameter("number_of_people")),
                Boolean.parseBoolean(request.getParameter("service_type")),
                request.getParameter("status"),
                request.getParameter("special_requests"));

        var isSuccess = DatabaseUtilizer.updateReservation(reservation);
    }

    private void addReservations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var reservation = new ReservationsModel(
                0,
                Integer.parseInt(request.getParameter("customer_id")),
                request.getParameter("reservation_date"),
                request.getParameter("reservation_time"),
                Integer.parseInt(request.getParameter("number_of_people")),
                Boolean.parseBoolean(request.getParameter("service_type")),
                request.getParameter("status"),
                request.getParameter("special_requests"));
        var isSuccess = DatabaseUtilizer.addReservation(reservation);
    }

}
