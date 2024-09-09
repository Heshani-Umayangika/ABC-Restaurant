/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Kelum
 */
public class LoginModel {

     public int getUser_id() {
        return user_id;
    }
    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public LoginModel(int user_id,String first_name, String last_name, String user_type) {
         this.user_id = user_id;
         this.first_name = first_name;
        this.last_name = last_name;
        this.user_type = user_type;
    }
    private int user_id;
    private String first_name;
    private String last_name;
    private String user_type;
}
