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

    public PaymentsModel(int payment_id, int reservation_id, String payment_date, String payment_method, boolean payment_status) {
        this.payment_id = payment_id;
        this.reservation_id = reservation_id;
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
    }
    private int payment_id;
    private int reservation_id;
    private String payment_date;
    private String payment_method;
    private boolean payment_status;

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
}
