/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package AppServices;


import Models.FacilitiesModel;
import Models.OffersModel;
import Models.Inherited.ReservationsModel;
import Models.Inherited.ServicesModel;
import Models.UsersModel;
import java.math.BigDecimal;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Kelum
 */
public class DatabaseUtilizerNGTest {

    public DatabaseUtilizerNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    

    

    @Test
    public void testGetPaymentsList() {
        System.out.println("getPaymentsList");
        assertNotNull(RestaurantDatabaseUtilizer.getPaymentsList());
    }

    @Test
    public void testGetPayment() {
        System.out.println("getPayment");
        assertNotNull(RestaurantDatabaseUtilizer.getPayment(5));
    }

 
    @Test
    public void testGetUsersList() {
        System.out.println("getUsersList");
        assertNotNull(RestaurantDatabaseUtilizer.getUsersList());
    }

    @Test
    public void testGetUser() {
        System.out.println("getUser");
        assertNotNull(RestaurantDatabaseUtilizer.getUser(2));
    }

    @Test
    public void testAddUser() {
        System.out.println("addUser");
        assertTrue(RestaurantDatabaseUtilizer.addUser(new UsersModel(0,"Manula","Weerasinghe","0322265000","manula@mail.com","Narahenpita, colombo 5","Type","Pass")));
    }

    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        assertFalse(RestaurantDatabaseUtilizer.updateUser(null));
    }

    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        assertTrue(RestaurantDatabaseUtilizer.deleteUser(5));
    }


   

    @Test
    public void testSignIn() {
        System.out.println("signIn");
        assertNotNull(RestaurantDatabaseUtilizer.signIn("0719476645", "Abc@123"));
    }



    /**
     * Test of getFacilitiesList method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetFacilitiesList() {
        System.out.println("getFacilitiesList");

        assertNotNull(RestaurantDatabaseUtilizer.getFacilitiesList());

    }

    /**
     * Test of getFacility method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetFacility() {
        System.out.println("getFacility");
        int facilityId = 0;
        assertNull(RestaurantDatabaseUtilizer.getFacility(facilityId) );
    }

    /**
     * Test of addFacility method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testAddFacility() {
        System.out.println("addFacility");
        FacilitiesModel facility = null;
        assertFalse(RestaurantDatabaseUtilizer.addFacility(facility));
   
    }

    /**
     * Test of updateFacility method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testUpdateFacility() {
        System.out.println("updateFacility");
        FacilitiesModel facility = null;
        assertFalse(RestaurantDatabaseUtilizer.updateFacility(facility));
    }

    /**
     * Test of deleteFacility method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testDeleteFacility() {
        System.out.println("deleteFacility");
        int facilityId = 0;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.deleteFacility(facilityId);
        assertEquals(result, expResult);

    }

    /**
     * Test of getServicesList method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetServicesList() {
        System.out.println("getServicesList");
 
        assertNotNull(RestaurantDatabaseUtilizer.getServicesList());
    }

    /**
     * Test of getService method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");
        int serviceId = 0;
        ServicesModel expResult = null;
        ServicesModel result = RestaurantDatabaseUtilizer.getService(serviceId);
        assertEquals(result, expResult);
    }

    /**
     * Test of addService method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testAddService() {
        System.out.println("addService");
        ServicesModel service = null;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.addService(service);
        assertEquals(result, expResult);

    }

    /**
     * Test of updateService method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testUpdateService() {
        System.out.println("updateService");
        ServicesModel service = null;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.updateService(service);
        assertEquals(result, expResult);

    }

    /**
     * Test of deleteService method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testDeleteService() {
        System.out.println("deleteService");
        int serviceId = 0;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.deleteService(serviceId);
        assertEquals(result, expResult);

    }

    /**
     * Test of getOffersList method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetOffersList() {
        System.out.println("getOffersList");
        assertNotNull(RestaurantDatabaseUtilizer.getOffersList());
    }

    /**
     * Test of getOffer method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetOffer() {
        System.out.println("getOffer");
        int offerId = 0;
        OffersModel expResult = null;
        OffersModel result = RestaurantDatabaseUtilizer.getOffer(offerId);
        assertEquals(result, expResult);

    }

    /**
     * Test of addOffer method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testAddOffer() {
        System.out.println("addOffer");
        OffersModel offer = null;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.addOffer(offer);
        assertEquals(result, expResult);

    }

    /**
     * Test of updateOffer method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testUpdateOffer() {
        System.out.println("updateOffer");
        OffersModel offer = null;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.updateOffer(offer);
        assertEquals(result, expResult);

    }

    /**
     * Test of deleteOffer method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testDeleteOffer() {
        System.out.println("deleteOffer");
        int offerId = 0;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.deleteOffer(offerId);
        assertEquals(result, expResult);

    }

    /**
     * Test of getReservationsList method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetReservationsList() {
        System.out.println("getReservationsList");

        assertNotNull(RestaurantDatabaseUtilizer.getReservationsList());
;
    }

    /**
     * Test of getReservation method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetReservation() {
        System.out.println("getReservation");
        int reservationId = 0;
        ReservationsModel expResult = null;
        ReservationsModel result = RestaurantDatabaseUtilizer.getReservation(reservationId);
        assertEquals(result, expResult);
    }

    /**
     * Test of addReservation method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testAddReservation() {
        System.out.println("addReservation");
        ReservationsModel reservation = null;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.addReservation(reservation);
        assertEquals(result, expResult);

    }

    /**
     * Test of updateReservation method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testUpdateReservation() {
        System.out.println("updateReservation");
        ReservationsModel reservation = null;
        boolean expResult = false;
        boolean result = RestaurantDatabaseUtilizer.updateReservation(reservation);
        assertEquals(result, expResult);

    }

    /**
     * Test of deleteReservation method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testDeleteReservation() {
        System.out.println("deleteReservation");
        int reservationId = 0;
        assertFalse(RestaurantDatabaseUtilizer.deleteReservation(reservationId));

    }

    /**
     * Test of getCustomersDropdownList method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetCustomersDropdownList() {
        System.out.println("getCustomersDropdownList");
        List expResult = null;
        List result = RestaurantDatabaseUtilizer.getCustomersDropdownList();
        assertNotEquals(result, expResult);

    }

    /**
     * Test of getServicesDropdownList method, of class RestaurantDatabaseUtilizer.
     */
    @Test
    public void testGetServicesDropdownList() {
        System.out.println("getServicesDropdownList");
        List expResult = null;
        List result = RestaurantDatabaseUtilizer.getServicesDropdownList();
        assertNotEquals(result, expResult);

    }
}
