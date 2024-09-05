/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.DatabaseUtilizer;
import Models.FacilitiesModel;
import Models.OffersModel;
import Models.Inherited.ServicesModel;
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

@WebServlet(name = "OffersController", urlPatterns = {"/Offers"})
public class OffersController extends HttpServlet {

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
                    getEditOffers(request, response);
                } else if ("Add".equals(page)) {
                    getAddOffers(request, response);
                } else if ("Delete".equals(page)) {
                    getDeleteOffers(request, response);
                } else {
                    getOffersList(request, response);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    private void getEditOffers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var offerId = Integer.parseInt(request.getParameter("offerId"));
        var offer = DatabaseUtilizer.getOffer(offerId);

        request.setAttribute("offer", offer);
        request.getRequestDispatcher("/Views/Offers/edit_offers.jsp").forward(request, response);
    }

    private void getAddOffers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Offers/add_offers.jsp").forward(request, response);
    }

    private void getDeleteOffers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var offerId = Integer.parseInt(request.getParameter("offerId"));
        request.setAttribute("offerId", offerId);
        request.getRequestDispatcher("/Views/Offers/delete_offers.jsp").forward(request, response);
    }

    private void getOffersList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var offersList = DatabaseUtilizer.getOffersList();
        request.setAttribute("offersList", offersList);
        request.getRequestDispatcher("/Views/Offers/offers.jsp").forward(request, response);
    }

//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var action = request.getParameter("action");
        if ("Delete".equals(action)) {
            deleteOffers(request, response);
        } else if ("Update".equals(action)) {
            updateOffers(request, response);
        } else {
            addOffers(request, response);
        }
    }

    private void deleteOffers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var offerId = Integer.parseInt(request.getParameter("offerId"));
        var isSuccess = DatabaseUtilizer.deleteOffer(offerId);
    }

    private void updateOffers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var offer = new OffersModel(
                Integer.parseInt(request.getParameter("offer_id")),
                request.getParameter("offer_name"),
                request.getParameter("description"),
                request.getParameter("start_date"),
                request.getParameter("end_date"),
                new BigDecimal(request.getParameter("discount_percentage")));
        var isSuccess = DatabaseUtilizer.updateOffer(offer);
    }

    private void addOffers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var offer = new OffersModel(
                0,
                request.getParameter("offer_name"),
                request.getParameter("description"),
                request.getParameter("start_date"),
                request.getParameter("end_date"),
                new BigDecimal(request.getParameter("discount_percentage")));
        var isSuccess = DatabaseUtilizer.addOffer(offer);
    }

}
