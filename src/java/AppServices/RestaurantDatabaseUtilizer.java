/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppServices;

import AppServices.DatabaseConnector;
import Models.CustomersListModel;
import Models.FacilitiesModel;
import Models.LoginModel;
import Models.OffersModel;
import Models.PaymentsModel;
import Models.Inherited.ReservationsModel;
import Models.Inherited.ReservationsViewModel;
import Models.Base.ServicesBaseModel;
import Models.DailySummaryModel;
import Models.Inherited.ServicesModel;
import Models.Inherited.InquiriesModel;
import Models.Inherited.InquiriesViewModel;
import Models.ProgressModel;
import Models.UsersModel;
import jakarta.resource.cci.ResultSet;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kelum
 */
public class RestaurantDatabaseUtilizer {

    // Login Section -----------------------------------------------------------
    public static LoginModel signIn(String username, String password) {
        LoginModel user = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL SignIn(?,?) }");
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                user = new LoginModel(resultSet.getInt("user_id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("user_type"));
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
    // Services Section --------------------------------------------------------
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

    // Services Section --------------------------------------------------------
    //
    //    
    //    
    // Offers Section ----------------------------------------------------------
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

    // Offers Section ----------------------------------------------------------
    //
    //    
    //  
    // Reservation Section -----------------------------------------------------
    public static List<ReservationsViewModel> getReservationsList() {
        var reservationsList = new ArrayList<ReservationsViewModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadReservations()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var reservation = new ReservationsViewModel(resultSet.getInt("reservation_id"), resultSet.getInt("customer_id"), resultSet.getString("reservation_date"), resultSet.getString("reservation_time"), resultSet.getInt("number_of_people"), resultSet.getString("service_name"), resultSet.getBoolean("service_type"), resultSet.getString("status"), resultSet.getString("special_requests"));
                reservationsList.add(reservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return reservationsList;
    }

    public static List<ReservationsViewModel> getUserReservationsList(int userId) {
        var userReservationsList = new ArrayList<ReservationsViewModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadUserReservations(?)}");
                callableStatement.setInt(1, userId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
               var reservation = new ReservationsViewModel(resultSet.getInt("reservation_id"), resultSet.getInt("customer_id"), resultSet.getString("reservation_date"), resultSet.getString("reservation_time"), resultSet.getInt("number_of_people"), resultSet.getString("service_name"), resultSet.getBoolean("service_type"), resultSet.getString("status"), resultSet.getString("special_requests"));
               userReservationsList.add(reservation);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return userReservationsList;
    }
    public static ReservationsModel getReservation(int reservationId) {
        ReservationsModel reservation = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadReservation(?)}");
            callableStatement.setInt(1, reservationId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                reservation = new ReservationsModel(resultSet.getInt("reservation_id"), resultSet.getInt("customer_id"), resultSet.getString("reservation_date"), resultSet.getString("reservation_time"), resultSet.getInt("number_of_people"), resultSet.getInt("service_id"), resultSet.getBoolean("service_type"), resultSet.getString("status"), resultSet.getString("special_requests"));
            }
        } catch (Exception e) {
        }
        return reservation;
    }

    public static boolean addReservation(ReservationsModel reservation) {

        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL CreateReservation(?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, reservation.getCustomer_id());
            callableStatement.setString(2, reservation.getReservation_date());
            callableStatement.setString(3, reservation.getReservation_time());
            callableStatement.setInt(4, reservation.getNumber_of_people());
            callableStatement.setInt(5, reservation.getService_id());
            callableStatement.setBoolean(6, reservation.isService_type());
            callableStatement.setString(7, reservation.getStatus());
            callableStatement.setString(8, reservation.getSpecial_requests());

            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean updateReservation(ReservationsModel reservation) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL UpdateReservation(?,?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, reservation.getReservation_id());
            callableStatement.setInt(2, reservation.getCustomer_id());
            callableStatement.setString(3, reservation.getReservation_date());
            callableStatement.setString(4, reservation.getReservation_time());
            callableStatement.setInt(5, reservation.getNumber_of_people());
            callableStatement.setInt(6, reservation.getService_id());
            callableStatement.setBoolean(7, reservation.isService_type());
            callableStatement.setString(8, reservation.getStatus());
            callableStatement.setString(9, reservation.getSpecial_requests());

            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    public static boolean deleteReservation(int reservationId) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL DeleteReservation(?) }");
            callableStatement.setInt(1, reservationId);
            var rowsAffected = callableStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public static List<CustomersListModel> getCustomersDropdownList() {
        var customersList = new ArrayList<CustomersListModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadCustomersList()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var customer = new CustomersListModel(resultSet.getInt("user_id"), resultSet.getString("customer_name"));
                customersList.add(customer);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return customersList;
    }

    public static List<ServicesBaseModel> getServicesDropdownList() {
        var servicesList = new ArrayList<ServicesBaseModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadServicesList()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var service = new ServicesBaseModel(resultSet.getInt("service_id"), resultSet.getString("service_name"));
                servicesList.add(service);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return servicesList;
    }

    // Reservation Section -----------------------------------------------------
//    
//    
//    
    // Payments Section --------------------------------------------------------
    public static List<PaymentsModel> getPaymentsList() {
        var paymentsList = new ArrayList<PaymentsModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadPayments()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var payment = new PaymentsModel(resultSet.getInt("payment_id"), resultSet.getInt("reservation_id"), resultSet.getString("payment_date"), resultSet.getString("payment_method"), resultSet.getBoolean("payment_status"));
                paymentsList.add(payment);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return paymentsList;
    }

    public static PaymentsModel getPayment(int paymentId) {
        PaymentsModel payment = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadPayment(?)}");
            callableStatement.setInt(1, paymentId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                payment = new PaymentsModel(resultSet.getInt("payment_id"), resultSet.getInt("reservation_id"), resultSet.getString("payment_date"), resultSet.getString("payment_method"), resultSet.getBoolean("payment_status"));
            }
        } catch (Exception e) {
        }
        return payment;
    }

    public static boolean updatePayment(PaymentsModel payment) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL UpdatePayment(?,?,?)}");
            callableStatement.setInt(1, payment.getPayment_id());
            callableStatement.setString(2, payment.getPayment_method());
            callableStatement.setBoolean(3, payment.isPayment_status());

            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }

    // Payments Section --------------------------------------------------------
//    
//    
//    
    // Progress Section --------------------------------------------------------
    public static DailySummaryModel getDailySummary() {
        DailySummaryModel summary = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadDailySummary()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                summary = new DailySummaryModel(resultSet.getBigDecimal("total_income_today"), resultSet.getInt("total_customers"), resultSet.getInt("total_reservations_today"), resultSet.getInt("total_paid_reservations_today"));
            }
        } catch (Exception e) {
        }
        return summary;
    }

    public static List<ReservationsViewModel> getLatestDineIn() {
        var summaryList = new ArrayList<ReservationsViewModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadLatestDineInReservations()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var summary = new ReservationsViewModel(resultSet.getInt("reservation_id"), resultSet.getInt("customer_id"), resultSet.getString("reservation_date"), resultSet.getString("reservation_time"), resultSet.getInt("number_of_people"), resultSet.getString("service_name"), false, "", resultSet.getString("special_requests"));
                summaryList.add(summary);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return summaryList;
    }

    public static List<ReservationsViewModel> getLatestDelivery() {
        var summaryList = new ArrayList<ReservationsViewModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadLatestDeliveryOrders()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var summary = new ReservationsViewModel(resultSet.getInt("reservation_id"), resultSet.getInt("customer_id"), resultSet.getString("reservation_date"), resultSet.getString("reservation_time"), resultSet.getInt("number_of_people"), resultSet.getString("service_name"), false, "", resultSet.getString("special_requests"));
                summaryList.add(summary);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return summaryList;
    }

    public static List<ProgressModel> getLastMonthProgress() {
        var progressList = new ArrayList<ProgressModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadLastMonthProgress()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var progress = new ProgressModel( resultSet.getString("payment_day"), resultSet.getBigDecimal("daily_total_income"));
                progressList.add(progress);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return progressList;
    }
    
    public static List<ProgressModel> getThisMonthProgress() {
        var progressList = new ArrayList<ProgressModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadThisMonthProgress()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var progress = new ProgressModel( resultSet.getString("payment_day"), resultSet.getBigDecimal("daily_total_income"));
                progressList.add(progress);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return progressList;
    }
    // Progress Section --------------------------------------------------------
//
//
//    
    // Inquiries Section -------------------------------------------------------
        public static List<InquiriesViewModel> getInquiriesList() {
        var inquiriesList = new ArrayList<InquiriesViewModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadInquiries()}");
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var inquiry = new InquiriesViewModel(resultSet.getInt("inquiry_id"), resultSet.getString("customer_name"), resultSet.getString("subject"), resultSet.getString("message"),resultSet.getString("submitted_at"));
                inquiriesList.add(inquiry);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return inquiriesList;
    }
        
    public static List<InquiriesViewModel> getUserInquiriesList(int userId) {
        var userInquiriesList = new ArrayList<InquiriesViewModel>();
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL ReadUserInquiries(?)}");
                callableStatement.setInt(1, userId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                var inquiry = new InquiriesViewModel(resultSet.getInt("inquiry_id"), resultSet.getString("customer_name"), resultSet.getString("subject"), resultSet.getString("message"),resultSet.getString("submitted_at"));
                userInquiriesList.add(inquiry);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return userInquiriesList;
    }
    
        public static InquiriesModel getInquiry(int inquiryId) {
        InquiriesModel inquiry = null;
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL ReadInquiry(?)}");
            callableStatement.setInt(1, inquiryId);
            var resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                inquiry = new InquiriesModel(resultSet.getInt("inquiry_id"), resultSet.getInt("user_id"), resultSet.getString("subject"), resultSet.getString("message"),resultSet.getString("submitted_at"));
            }
        } catch (Exception e) {
        }
        return inquiry;
    }
        
        public static boolean addInquiry(InquiriesModel inquiry) {

        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{CALL CreateInquiry(?,?,?)}");
            callableStatement.setInt(1, inquiry.getUser_id());
            callableStatement.setString(2, inquiry.getSubject());
            callableStatement.setString(3, inquiry.getMessage());
  
            var rowsAffected = callableStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
        
            public static boolean deleteInquiry(int reservationId) {
        try (var connection = DatabaseConnector.getConnection()) {
            var callableStatement = connection.prepareCall("{ CALL DeleteInquiry(?) }");
            callableStatement.setInt(1, reservationId);
            var rowsAffected = callableStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
        }
        return false;
    }
    // Inquiries Section -------------------------------------------------------
}
