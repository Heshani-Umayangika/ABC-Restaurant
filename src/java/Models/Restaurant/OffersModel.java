/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Restaurant;

import java.math.BigDecimal;

/**
 *
 * @author Kelum
 */
public class OffersModel {

    public OffersModel(int offer_id, String offer_name, String description, String start_date, String end_date, BigDecimal discount_percentage) {
        this.offer_id = offer_id;
        this.offer_name = offer_name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.discount_percentage = discount_percentage;
    }
    private int offer_id;
    private String offer_name;
    private String description;
    private String start_date;
    private String end_date;
    private BigDecimal discount_percentage;

    public int getOffer_id() {
        return offer_id;
    }

    public String getOffer_name() {
        return offer_name;
    }

    public String getDescription() {
        return description;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public BigDecimal getDiscount_percentage() {
        return discount_percentage;
    }
}
