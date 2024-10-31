package com.example.RBD.DTO;

import com.example.RBD.Entity.UserEntity;
import com.example.RBD.Entity.AddressEntity;
import java.util.*;

//import org.antlr.v4.runtime.misc.NotNull;

public class RegisterUser {

    private UserEntity user;
    private List<AddressEntity> address;
    private String username;
    private String useremail;
    private String userpass;
    private List<String> roles;
    public String[] get;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<AddressEntity> getAddress() {
        return address;
    }

    public void setAddress(List<AddressEntity> address) {
        this.address = address;
    }

    public Object findByrname(String rname) {
        throw new UnsupportedOperationException("Unimplemented method 'findByrname'");
    }

}
