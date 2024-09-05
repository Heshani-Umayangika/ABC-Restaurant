/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Inherited;

import java.math.BigDecimal;
import Models.Base.ServicesBaseModel;
/**
 *
 * @author Kelum
 */
public class ServicesModel extends ServicesBaseModel{

    public ServicesModel(int service_id, String service_name, String description, BigDecimal rate) {
        super(service_id,service_name);
        this.description = description;
        this.rate = rate;
    }

    private String description;
    private BigDecimal rate;

    public String getDescription() {
        return description;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
