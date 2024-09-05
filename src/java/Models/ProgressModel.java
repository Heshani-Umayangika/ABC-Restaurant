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
public class ProgressModel {

    public ProgressModel(String payment_day, BigDecimal daily_total_income) {
        this.payment_day = payment_day;
        this.daily_total_income = daily_total_income;
    }

    private String payment_day;
    private BigDecimal daily_total_income;

    public String getPayment_day() {
        return payment_day;
    }

    public BigDecimal getDaily_total_income() {
        return daily_total_income;
    }
}
