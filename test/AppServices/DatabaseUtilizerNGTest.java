/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package AppServices;


import Models.FacilitiesModel;
import Models.OffersModel;
import Models.Inherited.ReservationsModel;
import Models.ServicesModel;
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
        assertNotNull(DatabaseUtilizer.getPaymentsList());
    }

    @Test
    public void testGetPayment() {
        System.out.println("getPayment");
        assertNotNull(DatabaseUtilizer.getPayment(5));
    }

 
    @Test
    public void testGetUsersList() {
        System.out.println("getUsersList");
        assertNotNull(DatabaseUtilizer.getUsersList());
    }

    @Test
    public void testGetUser() {
        System.out.println("getUser");
        assertNotNull(DatabaseUtilizer.getUser(2));
    }

    @Test
    public void testAddUser() {
        System.out.println("addUser");
        assertTrue(DatabaseUtilizer.addUser(new UsersModel(0,"Manula","Weerasinghe","0322265000","manula@mail.com","Narahenpita, colombo 5","Type","Pass")));
    }

    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        assertFalse(DatabaseUtilizer.updateUser(null));
    }

    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        assertTrue(DatabaseUtilizer.deleteUser(5));
    }


   

    @Test
    public void testSignIn() {
        System.out.println("signIn");
        assertNotNull(DatabaseUtilizer.signIn("0719476645", "Abc@123"));
    }



    /**
     * Test of getFacilitiesList method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetFacilitiesList() {
        System.out.println("getFacilitiesList");

        assertNotNull(DatabaseUtilizer.getFacilitiesList());

    }

    /**
     * Test of getFacility method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetFacility() {
        System.out.println("getFacility");
        int facilityId = 0;
        assertNull(DatabaseUtilizer.getFacility(facilityId) );
    }

    /**
     * Test of addFacility method, of class DatabaseUtilizer.
     */
    @Test
    public void testAddFacility() {
        System.out.println("addFacility");
        FacilitiesModel facility = null;
        assertFalse(DatabaseUtilizer.addFacility(facility));
   
    }

    /**
     * Test of updateFacility method, of class DatabaseUtilizer.
     */
    @Test
    public void testUpdateFacility() {
        System.out.println("updateFacility");
        FacilitiesModel facility = null;
        assertFalse(DatabaseUtilizer.updateFacility(facility));
    }

    /**
     * Test of deleteFacility method, of class DatabaseUtilizer.
     */
    @Test
    public void testDeleteFacility() {
        System.out.println("deleteFacility");
        int facilityId = 0;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.deleteFacility(facilityId);
        assertEquals(result, expResult);

    }

    /**
     * Test of getServicesList method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetServicesList() {
        System.out.println("getServicesList");
 
        assertNotNull(DatabaseUtilizer.getServicesList());
    }

    /**
     * Test of getService method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetService() {
        System.out.println("getService");
        int serviceId = 0;
        ServicesModel expResult = null;
        ServicesModel result = DatabaseUtilizer.getService(serviceId);
        assertEquals(result, expResult);
    }

    /**
     * Test of addService method, of class DatabaseUtilizer.
     */
    @Test
    public void testAddService() {
        System.out.println("addService");
        ServicesModel service = null;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.addService(service);
        assertEquals(result, expResult);

    }

    /**
     * Test of updateService method, of class DatabaseUtilizer.
     */
    @Test
    public void testUpdateService() {
        System.out.println("updateService");
        ServicesModel service = null;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.updateService(service);
        assertEquals(result, expResult);

    }

    /**
     * Test of deleteService method, of class DatabaseUtilizer.
     */
    @Test
    public void testDeleteService() {
        System.out.println("deleteService");
        int serviceId = 0;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.deleteService(serviceId);
        assertEquals(result, expResult);

    }

    /**
     * Test of getOffersList method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetOffersList() {
        System.out.println("getOffersList");
        assertNotNull(DatabaseUtilizer.getOffersList());
    }

    /**
     * Test of getOffer method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetOffer() {
        System.out.println("getOffer");
        int offerId = 0;
        OffersModel expResult = null;
        OffersModel result = DatabaseUtilizer.getOffer(offerId);
        assertEquals(result, expResult);

    }

    /**
     * Test of addOffer method, of class DatabaseUtilizer.
     */
    @Test
    public void testAddOffer() {
        System.out.println("addOffer");
        OffersModel offer = null;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.addOffer(offer);
        assertEquals(result, expResult);

    }

    /**
     * Test of updateOffer method, of class DatabaseUtilizer.
     */
    @Test
    public void testUpdateOffer() {
        System.out.println("updateOffer");
        OffersModel offer = null;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.updateOffer(offer);
        assertEquals(result, expResult);

    }

    /**
     * Test of deleteOffer method, of class DatabaseUtilizer.
     */
    @Test
    public void testDeleteOffer() {
        System.out.println("deleteOffer");
        int offerId = 0;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.deleteOffer(offerId);
        assertEquals(result, expResult);

    }

    /**
     * Test of getReservationsList method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetReservationsList() {
        System.out.println("getReservationsList");

        assertNotNull(DatabaseUtilizer.getReservationsList());
;
    }

    /**
     * Test of getReservation method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetReservation() {
        System.out.println("getReservation");
        int reservationId = 0;
        ReservationsModel expResult = null;
        ReservationsModel result = DatabaseUtilizer.getReservation(reservationId);
        assertEquals(result, expResult);
    }

    /**
     * Test of addReservation method, of class DatabaseUtilizer.
     */
    @Test
    public void testAddReservation() {
        System.out.println("addReservation");
        ReservationsModel reservation = null;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.addReservation(reservation);
        assertEquals(result, expResult);

    }

    /**
     * Test of updateReservation method, of class DatabaseUtilizer.
     */
    @Test
    public void testUpdateReservation() {
        System.out.println("updateReservation");
        ReservationsModel reservation = null;
        boolean expResult = false;
        boolean result = DatabaseUtilizer.updateReservation(reservation);
        assertEquals(result, expResult);

    }

    /**
     * Test of deleteReservation method, of class DatabaseUtilizer.
     */
    @Test
    public void testDeleteReservation() {
        System.out.println("deleteReservation");
        int reservationId = 0;
        assertFalse(DatabaseUtilizer.deleteReservation(reservationId));

    }

    /**
     * Test of getCustomersDropdownList method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetCustomersDropdownList() {
        System.out.println("getCustomersDropdownList");
        List expResult = null;
        List result = DatabaseUtilizer.getCustomersDropdownList();
        assertNotEquals(result, expResult);

    }

    /**
     * Test of getServicesDropdownList method, of class DatabaseUtilizer.
     */
    @Test
    public void testGetServicesDropdownList() {
        System.out.println("getServicesDropdownList");
        List expResult = null;
        List result = DatabaseUtilizer.getServicesDropdownList();
        assertNotEquals(result, expResult);

    }
}
