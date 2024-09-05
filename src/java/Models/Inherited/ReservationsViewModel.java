/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Inherited;

import Models.Base.ReservationsBaseModel;

/**
 *
 * @author Kelum
 */
public class ReservationsViewModel extends ReservationsBaseModel {

    public ReservationsViewModel(int reservation_id, int customer_id, String reservation_date, String reservation_time, int number_of_people, String service_name, boolean service_type, String status, String special_requests) {

        super(reservation_id, customer_id, reservation_date, reservation_time, number_of_people, service_type, status, special_requests);
        this.service_name = service_name;
    }

    private String service_name;

    public String getService_name() {
        return service_name;
    }
}
