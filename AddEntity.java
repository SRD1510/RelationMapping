package com.example.RBD.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class AddEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long add_id;

    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postalcode;

    @Column(nullable = false)
    private String t_add;

    @Column(nullable = false)
    private String p_add;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private UserEntity user;

    public long getAdd_id() {
        return add_id;
    }

    public void setAdd_id(long add_id) {
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

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getT_add() {
        return t_add;
    }

    public void setT_add(String t_add) {
        this.t_add = t_add;
    }

    public String getP_add() {
        return p_add;
    }

    public void setP_add(String p_add) {
        this.p_add = p_add;
    }

    public List<AddEntity> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }
}