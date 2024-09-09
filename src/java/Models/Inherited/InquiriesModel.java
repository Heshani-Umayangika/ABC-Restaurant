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
public class InquiriesModel extends InquiriesBaseModel {

    public int getUser_id() {
        return user_id;
    }

    public InquiriesModel(int inquiry_id, int user_id, String subject, String message, String submitted_at) {
        super(inquiry_id, subject, message, submitted_at);
        this.user_id = user_id;
    }

    private int user_id;

}
