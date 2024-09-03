/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Restaurant;

/**
 *
 * @author Kelum
 */
public class FacilitiesModel {

    public FacilitiesModel(int facility_id, String facility_name, String description, boolean availability_status) {
        this.facility_id = facility_id;
        this.facility_name = facility_name;
        this.description = description;
        this.availability_status = availability_status;
    }
    private int facility_id;
    private String facility_name;
    private String description;
    private boolean availability_status;

    public int getFacility_id() {
        return facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailability_status() {
        return availability_status;
    }
}
