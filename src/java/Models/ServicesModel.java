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
public class ServicesModel {

    public ServicesModel(int service_id, String service_name, String description, BigDecimal rate) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.description = description;
        this.rate = rate;
    }
    private int service_id;
    private String service_name;
    private String description;
    private BigDecimal rate;

    public int getService_id() {
        return service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
