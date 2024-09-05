/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.DatabaseUtilizer;
import Models.FacilitiesModel;
import Models.PaymentsModel;
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

@WebServlet(name = "PaymentsController", urlPatterns = {"/Payments"})
public class PaymentsController extends HttpServlet {

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
                    getEditPayment(request, response);
                } else {
                    getPaymentsList(request, response);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    private void getEditPayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var paymentId = Integer.parseInt(request.getParameter("paymentId"));
        var payment = DatabaseUtilizer.getPayment(paymentId);

        request.setAttribute("payment", payment);
        request.getRequestDispatcher("/Views/Payments/edit_payment.jsp").forward(request, response);
    }

    private void getPaymentsList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var paymentsList = DatabaseUtilizer.getPaymentsList();
        request.setAttribute("paymentsList", paymentsList);
        request.getRequestDispatcher("/Views/Payments/payments.jsp").forward(request, response);
    }

//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var action = request.getParameter("action");
        if ("Update".equals(action)) {
            updatePayment(request, response);
        } else {
            System.err.println("Wront Method");
        }
    }


    private void updatePayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var payment = new PaymentsModel(Integer.parseInt(request.getParameter("payment_id")),0, "",request.getParameter("payment_method"), (request.getParameter("payment_status") != null));
        var isSuccess = DatabaseUtilizer.updatePayment(payment);
    }

}
