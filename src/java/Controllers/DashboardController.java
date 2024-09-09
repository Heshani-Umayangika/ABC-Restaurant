/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.RestaurantDatabaseUtilizer;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DashboardController", urlPatterns = {"/Dashboard"})
public class DashboardController extends HttpServlet {

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

                getDashboard(request, response);

            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    private void getDashboard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var dailySummary = RestaurantDatabaseUtilizer.getDailySummary();
        request.setAttribute("dailySummary", dailySummary);

        var dineInList = RestaurantDatabaseUtilizer.getLatestDineIn();
        request.setAttribute("dineInList", dineInList);

        var deliveryList = RestaurantDatabaseUtilizer.getLatestDelivery();
        request.setAttribute("deliveryList", deliveryList);

        var lastMonth = RestaurantDatabaseUtilizer.getLastMonthProgress();
        List<String> lastMonthDays = new ArrayList<>();
        List<BigDecimal> lastMonthCounts = new ArrayList<>();
        for (var item : lastMonth) {
            lastMonthDays.add("'" + item.getPayment_day() + "'");
            lastMonthCounts.add(item.getDaily_total_income());
        }
        request.setAttribute("lastMonthDays", lastMonthDays);
        request.setAttribute("lastMonthCounts", lastMonthCounts);

        var thisMonth = RestaurantDatabaseUtilizer.getThisMonthProgress();
        List<String> thisMonthDays = new ArrayList<>();
        List<BigDecimal> thisMonthCounts = new ArrayList<>();
        for (var item : thisMonth) {
            thisMonthDays.add("'" + item.getPayment_day() + "'");
            thisMonthCounts.add(item.getDaily_total_income());
        }
        request.setAttribute("thisMonthDays", thisMonthDays);
        request.setAttribute("thisMonthCounts", thisMonthCounts);

        request.getRequestDispatcher("/Views/Dashboard/dashboard.jsp").forward(request, response);
    }

}
