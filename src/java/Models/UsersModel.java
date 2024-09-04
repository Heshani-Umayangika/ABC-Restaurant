/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Kelum
 */
public class UsersModel {

    public UsersModel(int user_id, String first_name, String last_name, String phone_number, String email, String address, String user_type, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.user_type = user_type;
        this.password = password;
    }

    private int user_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String address;
    private String user_type;
    private String password;

    public int getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getPassword() {
        return password;
    }

}
