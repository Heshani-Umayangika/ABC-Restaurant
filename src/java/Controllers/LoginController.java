/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.DatabaseUtilizer;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import com.google.gson.JsonObject;

/**
 *
 * @author Kelum
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var page = request.getParameter("page");
        switch (page) {
            case "signin" -> {
                getSignIn(request, response);
            }
            case "signout" -> {
                getSignOut(request, response);
            }
            case "changepassword" -> {
                getChangePassword(request, response);
            }
        }
    }

    private void getSignIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/Login/login.jsp");
        dispatcher.forward(request, response);
    }

    private void getSignOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("redirectUrl", "/ABC_Restaurant");
        Gson gson = new Gson();
        String json = gson.toJson(jsonObject);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private void getChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/Login/change_password.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var page = request.getParameter("page");
        switch (page) {
            case "signin" -> {
                signIn(request, response);
            }
            case "changepassword" -> {
//                changePassword(request, response);
            }
        }
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var session = request.getSession();
        var user = DatabaseUtilizer.signIn(request.getParameter("username"), request.getParameter("password"));
        if (user != null) {
            session.setAttribute("isUser", true);
            session.setAttribute("userName", user.getFirst_name() + " " + user.getLast_name());
            session.setAttribute("authType", user.getUser_type());
            response.sendRedirect("/ABC_Restaurant/Home");
        } else {
            
            session.setAttribute("isUser", false);
            response.sendRedirect("/ABC_Restaurant/Login?page=signin");
        }
    }

}
