/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Kelum
 */
public class CustomersListModel {

    public CustomersListModel(int user_id, String customer_name) {
        this.user_id = user_id;
        this.customer_name = customer_name;
    }

    private int user_id;
    private String customer_name;

    public int getUser_id() {
        return user_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

}
