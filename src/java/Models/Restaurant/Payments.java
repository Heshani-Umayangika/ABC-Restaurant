/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Restaurant;

/**
 *
 * @author Kelum
 */
public class Payments {

    public Payments(int payment_id, int reservation_id, int amount, String payment_date, String payment_method, boolean payment_status) {
        this.payment_id = payment_id;
        this.reservation_id = reservation_id;
        this.amount = amount;
        this.payment_date = payment_date;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
    }
    private int payment_id;
    private int reservation_id;
    private int amount;
    private String payment_date;
    private String payment_method;
    private boolean payment_status;

    public int getPayment_id() {
        return payment_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public int getAmount() {
        return amount;
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
