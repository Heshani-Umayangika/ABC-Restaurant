/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.math.BigDecimal;

/**
 *
 * @author Kelum
 */
public class PaymentsModel {

    public int getPayment_id() {
        return payment_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public boolean isPayment_status() {
        return payment_status;
    }

    public int getNumber_of_people() {
        return number_of_people;
    }

    public String getService_name() {
        return service_name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getEmail() {
        return email;
    }

    public PaymentsModel(int payment_id, int reservation_id, String payment_date, String payment_method, boolean payment_status, int number_of_people, String service_name, BigDecimal rate, String customer_name, String email) {
        this.payment_id = payment_id;
        this.reservation_id = reservation_id;
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.number_of_people = number_of_people;
        this.service_name = service_name;
        this.rate = rate;
        this.customer_name = customer_name;
        this.email = email;
    }


    private int payment_id;
    private int reservation_id;
    private String payment_date;
    private String payment_method;
    private boolean payment_status;
    private int number_of_people;
    private String service_name;
    private BigDecimal rate;
    private String customer_name;
    private String email;

    
}
