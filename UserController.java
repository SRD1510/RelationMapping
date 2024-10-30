// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     @Autowired
//     private UserService userService;

//     @PostMapping("register")
//     public User registerUser(@RequestBody UserEntity user) {
//         return userService.registerUser(user);
//     }

//     @PostMapping("login")
//     public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
//         return userService.loginUser(user);
//     }
// }
package com.example.RBD.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import java.util.List;

import com.example.RBD.Entity.AddEntity;
import com.example.RBD.Entity.RoleEntity;
//import com.example.RBD.Entity.AddEntity;
import com.example.RBD.Entity.UserEntity;
import com.example.RBD.Service.UserService;
import com.example.RBD.DTO.LoginRequest;
import com.example.RBD.DTO.LoginResponse;
import com.example.RBD.DTO.RegisterUser;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.RBD.Repository.UserRepo;
import com.example.RBD.Repository.RoleRepo;
import com.example.RBD.DTO.LoginRequest;
import com.example.RBD.DTO.LoginResponse;
import com.example.RBD.DTO.RegisterUser;
import com.example.RBD.Entity.*;

@RestController
@CrossOrigin(origins = "http://localhost:5175")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    private RoleRepo rr;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody RegisterUser request) {
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setUseremail(request.getUseremail());
        user.setUserpass((request.getUserpass()));

        // Set roles
        // Set<RoleEntity> roles = new HashSet<>();
        // for (String rname : request.get) {
        // RoleEntity role = rr.findByrname(rname) // Use findByrname if your column is
        // named "rname"
        // .orElseThrow(() -> new RuntimeException("Role not found: " + rname));
        // roles.add(role);
        // }
        // user.setRoles(roles);

        // Set addresses
        for (AddEntity address : request.getAddress()) {
            address.setUser(user);
        }
        user.setAddresses(request.getAddress());

        return userService.saveUser(user); // Assuming a saveUser method in UserService
    }

    // private String encryptPassword(String userpass) {
    // // TODO Auto-generated method stub
    // // return new BCryptPasswordEncoder().encode(userpass);
    // // throw new UnsupportedOperationException("Unimplemented method
    // encryptPassword'");
    // }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }
}

// @PostMapping("/register")
// public UserEntity registerUser(@RequestBody UserEntity user, @RequestBody
// List<AddEntity> addresses) {
// UserEntity createdUser = userService.addUserWithAddresses(user, addresses);

// return userService.registerUser(user);
// }

// @PostMapping("/register")
// public UserEntity registerUser(@RequestBody RegisterUser rr) {
// UserEntity user = new UserEntity();
// user.setUsername(rr.getUsername());
// user.setUseremail(rr.getUseremail());
// user.setUserpass(encryptPassword(rr.getUserpass()));

// // Set roles
// Set<RoleEntity> roles = new HashSet<>();
// for (String rname : rr.getRoles()) {
// RoleEntity role = rr.findByrname(rname)
// .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
// roles.add(role);
// }
// user.setRoles(roles);

// // Set addresses
// for (AddEntity address : rr.getAdd()) {
// address.setUser(user);
// }
// user.setAddresses(registrationRequest.getAddresses());

// return userService.saveUser(user);
// }

// @PostMapping("/login")
