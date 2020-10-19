/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Teacher {
    private String id; 
    private String name;
    private String categogy;
    private String dob;
    private String email;
    private String address;
    private String phone;
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategogy() {
        return categogy;
    }

    public void setCategogy(String categogy) {
        this.categogy = categogy;
    }

    

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Teacher() {
    }

    public Teacher(String id, String name, String categogy, String topic, String dob, String email, String address, String image) {
        this.id = id;
        this.name = name;
        this.categogy = categogy;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.image = image;
    }
    
    
    
    
}
