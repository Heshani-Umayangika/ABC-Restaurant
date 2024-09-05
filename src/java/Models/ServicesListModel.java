/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Kelum
 */
public class ServicesListModel {

    public int getService_id() {
        return service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public ServicesListModel(int service_id, String service_name) {
        this.service_id = service_id;
        this.service_name = service_name;
    }
    private int service_id;
    private String service_name;
}
