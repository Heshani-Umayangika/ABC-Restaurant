/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import AppServices.RestaurantDatabaseUtilizer;
import Models.UsersModel;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Kelum
 */
@WebServlet(name = "UsersController", urlPatterns = {"/Users"})
public class UsersController extends HttpServlet {

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
                    getEditUser(request, response);
                } else if ("Add".equals(page)) {
                    getAddUser(request, response);
                } else if ("Delete".equals(page)) {
                    getDeleteUser(request, response);
                } else {
                    getUsersList(request, response);
                }
            }
        } else {
            response.sendRedirect("/ABC_Restaurant");
        }
    }

    // Loading User Edit Page [Slected User Retrieved]
    private void getEditUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var userId = Integer.parseInt(request.getParameter("userId"));
        var user = RestaurantDatabaseUtilizer.getUser(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/Views/Users/edit_user.jsp").forward(request, response);
    }

    //Loading User Add Page [Patients List and Technicians List Retrieved]
    private void getAddUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Users/add_user.jsp").forward(request, response);
    }

    //Loading User Delete Page [Selected User Retrieved]
    private void getDeleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var userId = request.getParameter("userId");
        request.setAttribute("userId", userId);
        request.getRequestDispatcher("/Views/Users/delete_user.jsp").forward(request, response);
    }

    // Loading Users Page [Users List Retrieved]
    private void getUsersList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var usersList = RestaurantDatabaseUtilizer.getUsersList();

        request.setAttribute("usersList", usersList);
        request.getRequestDispatcher("/Views/Users/users.jsp").forward(request, response);
    }

//Post Methods
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var action = request.getParameter("action");
        if ("Delete".equals(action)) {
            deleteUser(request, response);
        } else if ("Update".equals(action)) {
            updateUser(request, response);
        } else {
            addUser(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        var userId = Integer.parseInt(request.getParameter("user_id"));
        var isSuccess = RestaurantDatabaseUtilizer.deleteUser(userId);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var user = new UsersModel(
                Integer.parseInt(request.getParameter("user_id")),
                request.getParameter("first_name"),
                request.getParameter("last_name"),
                request.getParameter("phone_number"),
                request.getParameter("email"),
                request.getParameter("address"),
                request.getParameter("user_type"),
                request.getParameter("password"));
        var isSuccess = RestaurantDatabaseUtilizer.updateUser(user);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var user = new UsersModel(
                0,
                request.getParameter("first_name"),
                request.getParameter("last_name"),
                request.getParameter("phone_number"),
                request.getParameter("email"),
                request.getParameter("address"),
                request.getParameter("user_type"),
                request.getParameter("password"));
        var isSuccess = RestaurantDatabaseUtilizer.addUser(user);
    }

}
