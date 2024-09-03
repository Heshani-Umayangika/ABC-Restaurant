/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppServices;

import Models.Restaurant.FacilitiesModel;
import Models.Restaurant.LoginModel;
import Models.Restaurant.UsersModel;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kelum
 */
public class DatabaseUtilizer {

    // Login Section -----------------------------------------------------------
    public static LoginModel signIn(String username, String password) {
        LoginModel user = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL SignIn(?,?) }");
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                user = new LoginModel(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("user_type"));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return user;
    }
    // Login Section -----------------------------------------------------------

    // Users Section -----------------------------------------------------------
    public static List<UsersModel> getUsersList() {
        var usersList = new ArrayList<UsersModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadUsers()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var user = new UsersModel(resultSet.getInt("user_id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("phone_number"), resultSet.getString("email"), resultSet.getString("address"), resultSet.getString("user_type"), resultSet.getString("password"));
                usersList.add(user);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return usersList;
    }

    public static UsersModel getUser(int userId) {
        UsersModel user = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadUser(?)}");
            callableStatement.setInt(1, userId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                user = new UsersModel(resultSet.getInt("user_id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("phone_number"), resultSet.getString("email"), resultSet.getString("address"), resultSet.getString("user_type"), resultSet.getString("password"));
            }
        } catch (Exception e) {
        }
        return user;
    }

    public static boolean addUser(UsersModel user) {

        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL CreateUser(?,?,?,?,?,?,?)}");
            callableStatement.setString(1, user.getFirst_name());
            callableStatement.setString(2, user.getLast_name());
            callableStatement.setString(3, user.getPhone_number());
            callableStatement.setString(4, user.getEmail());
            callableStatement.setString(5, user.getAddress());
            callableStatement.setString(6, user.getUser_type());
            callableStatement.setString(7, user.getPassword());

            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean updateUser(UsersModel user) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL UpdateUser(?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, user.getUser_id());
            callableStatement.setString(2, user.getFirst_name());
            callableStatement.setString(3, user.getLast_name());
            callableStatement.setString(4, user.getPhone_number());
            callableStatement.setString(5, user.getEmail());
            callableStatement.setString(6, user.getAddress());
            callableStatement.setString(7, user.getUser_type());
            callableStatement.setString(8, user.getPassword());
            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean deleteUser(int userId) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL DeleteUser(?) }");
            callableStatement.setInt(1, userId);
            var rowsAffected = callableStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
        }
        return false;
    }
    // Users Section -----------------------------------------------------------

    // Facilities Section ------------------------------------------------------
    public static List<FacilitiesModel> getFacilitiesList() {
        var usersList = new ArrayList<FacilitiesModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadFacilities()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var facility = new FacilitiesModel(resultSet.getInt("facility_id"), resultSet.getString("facility_name"), resultSet.getString("description"), resultSet.getBoolean("availability_status"));
                usersList.add(facility);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return usersList;
    }

    public static FacilitiesModel getFacility(int facilityId) {
        FacilitiesModel facility = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadFacility(?)}");
            callableStatement.setInt(1, facilityId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                facility = new FacilitiesModel(resultSet.getInt("facility_id"), resultSet.getString("facility_name"), resultSet.getString("description"), resultSet.getBoolean("availability_status"));
            }
        } catch (Exception e) {
        }
        return facility;
    }

    public static boolean addFacility(FacilitiesModel facility) {

        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL CreateFacility(?,?,?)}");
            callableStatement.setString(1, facility.getFacility_name());
            callableStatement.setString(2, facility.getDescription());
            callableStatement.setBoolean(3, facility.isAvailability_status());

            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean updateFacility(FacilitiesModel facility) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL UpdateFacility(?,?,?,?)}");
            callableStatement.setInt(1, facility.getFacility_id());
            callableStatement.setString(2, facility.getFacility_name());
            callableStatement.setString(3, facility.getDescription());
            callableStatement.setBoolean(4, facility.isAvailability_status());
            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean deleteFacility(int facilityId) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL DeleteFacility(?) }");
            callableStatement.setInt(1, facilityId);
            var rowsAffected = callableStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
        }
        return false;
    }
    // Facilities Section ------------------------------------------------------

}
