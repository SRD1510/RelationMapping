package com.example.RBD.Controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.RBD.Entity.RoleEnity;
import com.example.RBD.Entity.UserEntity;
import com.example.RBD.Entity.UserRole;
import com.example.RBD.Repository.UserRepo;
import com.example.RBD.Service.RoleService;
import com.example.RBD.Service.UserService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        // userService.createUserWithDetails(user, user.getAddresses());

        // Add roles to the user
        // user.getRole().add(adminRole);
        // user.getRole().add(userRole);

        // RoleEnity enity = new RoleEnity();
        // enity.setRoleId(1);
        // enity.setRoleName("Admin");

        // roleService.saveRole(enity);
        // return userService.saveUser(user);

        // Set<RoleEnity> resolvedRoles = new HashSet<>();

        // for (UserRole role : user.getUserRoles()) {
        // RoleEnity existingRole = roleService.findRoleByName(role.getRoleName());
        // if (existingRole != null) {
        // resolvedRoles.add(existingRole);
        // } else {
        // // Optionally create a new role if it doesn't exist
        // RoleEnity newRole = new RoleEnity();
        // newRole.setRoleName(role.getRoleName());
        // resolvedRoles.add(roleService.saveRole(newRole));
        // }
        // }

        // // Set resolved roles in the UserEntity
        // user.setUserRoles(resolvedRoles);
        // // UserEntity createdUser = userService.saveUser(user);
        // // return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        // return userRepo.save(user);

        Set<RoleEnity> roleEnities = new HashSet<>();

        for (RoleEnity role : user.getUserRoles()) {
            RoleEnity roleEnity = new RoleEnity();

            roleEnity.setRoleName(role.getRoleName());
            roleEnities.add(roleEnity);
        }

        user.setUserRoles(roleEnities);
        return userService.saveUser(user);
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
}