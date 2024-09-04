/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Kelum
 */
public class InquiriesModel {

    public InquiriesModel(int inquiry_id, String email, String subject, String message, boolean status, String submitted_at) {
        this.inquiry_id = inquiry_id;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.submitted_at = submitted_at;
    }
    private int inquiry_id;
    private String email;
    private String subject;
    private String message;
    private boolean status;
    private String submitted_at;

    public int getInquiry_id() {
        return inquiry_id;
    }

    public String getCustomer_id() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }

    public String getSubmitted_at() {
        return submitted_at;
    }
}
