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
public class ReservationsModel extends ReservationsBaseModel {

    public ReservationsModel(int reservation_id, int customer_id, String reservation_date, String reservation_time, int number_of_people, int service_id, boolean service_type, String status, String special_requests) {
        super(reservation_id, customer_id, reservation_date, reservation_time, number_of_people, service_type, status, special_requests);
        this.service_id = service_id;
    }

    private int service_id;

    public int getService_id() {
        return service_id;
    }

}
