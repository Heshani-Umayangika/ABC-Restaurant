/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Restaurant;

/**
 *
 * @author Kelum
 */
public class LoginModel {

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public LoginModel(String first_name, String last_name, String user_type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_type = user_type;
    }
    private String first_name;
    private String last_name;
    private String user_type;
}
