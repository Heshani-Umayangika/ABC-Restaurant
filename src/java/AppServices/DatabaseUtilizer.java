/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppServices;

import AppServices.DatabaseConnector;
import Models.Restaurant.FacilitiesModel;
import Models.Restaurant.LoginModel;
import Models.Restaurant.OffersModel;
import Models.Restaurant.ServicesModel;
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
    //
    //    
    //    
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
    //
    //    
    //    
    // Facilities Section ------------------------------------------------------
    public static List<FacilitiesModel> getFacilitiesList() {
        var facilitiesList = new ArrayList<FacilitiesModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadFacilities()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var facility = new FacilitiesModel(resultSet.getInt("facility_id"), resultSet.getString("facility_name"), resultSet.getString("description"), resultSet.getBoolean("availability_status"));
                facilitiesList.add(facility);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return facilitiesList;
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
    //
    //    
    //    
    // Services Section ------------------------------------------------------
    public static List<ServicesModel> getServicesList() {
        var servicesList = new ArrayList<ServicesModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadServices()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var services = new ServicesModel(resultSet.getInt("service_id"), resultSet.getString("service_name"), resultSet.getString("description"), resultSet.getBigDecimal("rate"));
                servicesList.add(services);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return servicesList;
    }

    public static ServicesModel getService(int serviceId) {
        ServicesModel service = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadService(?)}");
            callableStatement.setInt(1, serviceId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                service = new ServicesModel(resultSet.getInt("service_id"), resultSet.getString("service_name"), resultSet.getString("description"), resultSet.getBigDecimal("rate"));
            }
        } catch (Exception e) {
        }
        return service;
    }

    public static boolean addService(ServicesModel service) {

        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL CreateService(?,?,?)}");
            callableStatement.setString(1, service.getService_name());
            callableStatement.setString(2, service.getDescription());
            callableStatement.setBigDecimal(3, service.getRate());

            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean updateService(ServicesModel service) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL UpdateService(?,?,?,?)}");
            callableStatement.setInt(1, service.getService_id());
            callableStatement.setString(2, service.getService_name());
            callableStatement.setString(3, service.getDescription());
            callableStatement.setBigDecimal(4, service.getRate());
            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean deleteService(int serviceId) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL DeleteService(?) }");
            callableStatement.setInt(1, serviceId);
            var rowsAffected = callableStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
        }
        return false;
    }

    // Services Section ------------------------------------------------------
    //
    //    
    //    
    // Offers Section ------------------------------------------------------
    public static List<OffersModel> getOffersList() {
        var offersList = new ArrayList<OffersModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadOffers()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var offers = new OffersModel(resultSet.getInt("offer_id"), resultSet.getString("offer_name"), resultSet.getString("description"), resultSet.getString("start_date"), resultSet.getString("end_date"), resultSet.getBigDecimal("discount_percentage"));
                offersList.add(offers);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return offersList;
    }

    public static OffersModel getOffer(int offerId) {
        OffersModel offer = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadOffer(?)}");
            callableStatement.setInt(1, offerId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                offer = new OffersModel(resultSet.getInt("offer_id"), resultSet.getString("offer_name"), resultSet.getString("description"), resultSet.getString("start_date"), resultSet.getString("end_date"), resultSet.getBigDecimal("discount_percentage"));
            }
        } catch (Exception e) {
        }
        return offer;
    }

    public static boolean addOffer(OffersModel offer) {

        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL CreateOffer(?,?,?,?,?)}");
            callableStatement.setString(1, offer.getOffer_name());
            callableStatement.setString(2, offer.getDescription());
            callableStatement.setString(3, offer.getStart_date());
            callableStatement.setString(4, offer.getEnd_date());
            callableStatement.setBigDecimal(5, offer.getDiscount_percentage());

            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean updateOffer(OffersModel offer) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL UpdateOffer(?,?,?,?,?,?)}");
            callableStatement.setInt(1, offer.getOffer_id());
            callableStatement.setString(2, offer.getOffer_name());
            callableStatement.setString(3, offer.getDescription());
            callableStatement.setString(4, offer.getStart_date());
            callableStatement.setString(5, offer.getEnd_date());
            callableStatement.setBigDecimal(6, offer.getDiscount_percentage());
            
            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean deleteOffer(int offerId) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL DeleteOffer(?) }");
            callableStatement.setInt(1, offerId);
            var rowsAffected = callableStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
        }
        return false;
    }
    // Offers Section ------------------------------------------------------
    //
    //    
    //    
}
