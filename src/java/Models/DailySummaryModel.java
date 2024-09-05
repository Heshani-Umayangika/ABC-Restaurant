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
public class DailySummaryModel {

    public DailySummaryModel(BigDecimal total_income_today, int total_customers, int total_reservations_today, int total_paid_reservations_today) {
        this.total_income_today = total_income_today;
        this.total_customers = total_customers;
        this.total_reservations_today = total_reservations_today;
        this.total_paid_reservations_today = total_paid_reservations_today;
    }

    private BigDecimal total_income_today;
    private int total_customers;
    private int total_reservations_today;
    private int total_paid_reservations_today;

    public BigDecimal getTotal_income_today() {
        return total_income_today;
    }

    public int getTotal_customers() {
        return total_customers;
    }

    public int getTotal_reservations_today() {
        return total_reservations_today;
    }

    public int getTotal_paid_reservations_today() {
        return total_paid_reservations_today;
    }
}
