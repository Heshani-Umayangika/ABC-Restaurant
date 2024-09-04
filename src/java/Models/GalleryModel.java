/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Kelum
 */
public class GalleryModel {

    public GalleryModel(int gallery_id, String image_url, String description) {
        this.gallery_id = gallery_id;
        this.image_url = image_url;
        this.description = description;
    }
    private int gallery_id;
    private String image_url;
    private String description;

    public int getGallery_id() {
        return gallery_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getDescription() {
        return description;
    }
}
