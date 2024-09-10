/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.RestaurantDatabaseUtilizer;
import Models.Inherited.InquiriesModel;
import Models.PaymentsModel;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@WebServlet(name = "MyPaymentsController", urlPatterns = {"/MyPayments"})
public class MyPaymentsController extends HttpServlet {

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
                if ("Pay".equals(page)) {
                    getMakePayment(request, response);
                } else {
                    int userId = (int) session.getAttribute("userId");
                    getMyPaymentsList(request, response, userId);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    private void getMakePayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var paymentId = Integer.parseInt(request.getParameter("paymentId"));
        var amount = request.getParameter("amount");
        request.setAttribute("amount", amount);
        request.setAttribute("paymentId", paymentId);
        request.getRequestDispatcher("/Views/Customer/make_payment.jsp").forward(request, response);
    }

    private void getMyPaymentsList(HttpServletRequest request, HttpServletResponse response, int userId)
            throws ServletException, IOException {
        var myPaymentsList = RestaurantDatabaseUtilizer.getUserPaymentsList(userId);
        request.setAttribute("myPaymentsList", myPaymentsList);
        request.getRequestDispatcher("/Views/Customer/my_payments.jsp").forward(request, response);
    }

//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        addMyPayment(request, response);
    }

    private void addMyPayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Add Method trigged");
        var payment = new PaymentsModel(Integer.parseInt(request.getParameter("payment_id")),0, "","Card", true,0,"",new BigDecimal(0.00),"","");
        var isSuccess = RestaurantDatabaseUtilizer.updatePayment(payment);
    }

}
