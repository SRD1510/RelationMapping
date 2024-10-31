package com.example.RBD.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long add_id;
    private String street;
    private String city;
    private Long postalcode;
    private String type = "P";
    // private boolean t_add = false;
    // private boolean p_add = false;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private UserEntity user;

    public Long getAdd_id() {
        return add_id;
    }

    public void setAdd_id(Long add_id) {
        this.add_id = add_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Long postalcode) {
        this.postalcode = postalcode;
    }

    /*
     * public boolean isT_add() {
     * return t_add;
     * }
     * 
     * public void setT_add(boolean t_add) {
     * this.t_add = t_add;
     * }
     * 
     * public boolean isP_add() {
     * return p_add;
     * }
     * 
     * public void setP_add(boolean p_add) {
     * this.p_add = p_add;
     * }
     */
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}