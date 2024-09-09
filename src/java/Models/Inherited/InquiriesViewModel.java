/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Inherited;

import Models.Base.InquiriesBaseModel;

/**
 *
 * @author Kelum
 */
public class InquiriesViewModel extends InquiriesBaseModel {

    public String getCustomer_name() {
        return customer_name;
    }

    public InquiriesViewModel(int inquiry_id, String customer_name, String subject, String message, String submitted_at) {
        super(inquiry_id, subject, message, submitted_at);
        this.customer_name = customer_name;
    }

    private String customer_name;

}
