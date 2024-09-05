/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Base;

/**
 *
 * @author Kelum
 */
public class ReservationsBaseModel {

    public int getReservation_id() {
        return reservation_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public String getReservation_time() {
        return reservation_time;
    }

    public int getNumber_of_people() {
        return number_of_people;
    }

    public boolean isService_type() {
        return service_type;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecial_requests() {
        return special_requests;
    }

    public ReservationsBaseModel(int reservation_id, int customer_id, String reservation_date, String reservation_time, int number_of_people, boolean service_type, String status, String special_requests) {
        this.reservation_id = reservation_id;
        this.customer_id = customer_id;
        this.reservation_date = reservation_date;
        this.reservation_time = reservation_time;
        this.number_of_people = number_of_people;
        this.service_type = service_type;
        this.status = status;
        this.special_requests = special_requests;
    }
    private int reservation_id;
    private int customer_id;
    private String reservation_date;
    private String reservation_time;
    private int number_of_people;
    private boolean service_type;
    private String status;
    private String special_requests;
}
