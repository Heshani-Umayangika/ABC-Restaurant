/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Base;

/**
 *
 * @author Kelum
 */
public class InquiriesBaseModel {

    public int getInquiry_id() {
        return inquiry_id;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getSubmitted_at() {
        return submitted_at;
    }

    public InquiriesBaseModel(int inquiry_id, String subject, String message, String submitted_at) {
        this.inquiry_id = inquiry_id;
        this.subject = subject;
        this.message = message;
        this.submitted_at = submitted_at;
    }
    private int inquiry_id;
    private String subject;
    private String message;
    private String submitted_at;
}
