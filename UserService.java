package com.example.RBD.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RBD.Entity.AddressEntity;
import com.example.RBD.Entity.RoleEnity;
import com.example.RBD.Entity.UserEntity;
import com.example.RBD.Entity.UserRole;
import com.example.RBD.Repository.RoleRepo;
import com.example.RBD.Repository.UserRepo;
import com.example.RBD.Repository.UserRoleRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    // public void createUserWithDetails(UserEntity user, List<AddEntity> addresses,
    // Set<RoleEntity> role) {
    // user.setAddresses(addresses); // Set addresses for the user
    // // user.setRole(role); // Set roles for the user

    // RoleEntity adminRole = new RoleEntity();
    // adminRole.setRid(1L);
    // adminRole.setRname("Admin");

    // RoleEntity userRole = new RoleEntity();
    // userRole.setRid(2L);
    // userRole.setRname("User");

    // user.getRole().add(adminRole);
    // user.getRole().add(userRole);
    // userRepo.save(user); // Save the user (addresses and roles will be saved
    // automatically)

    // }
    public void createUserWithDetails(UserEntity user, List<AddressEntity> addresses) {
        user.setAddresses(addresses);

        // if (user.getRole() == null) {
        // user.setRole(new HashSet<>());
        // }

        // Add roles to the user
        // user.getRole().add(adminRole);
        // user.getRole().add(userRole);

        // Set<RoleEntity> roles = new HashSet<>();
        // RoleEntity adminRole = roleRepo.findByRname("Admin");
        // RoleEntity userRole = roleRepo.findByRname("User");

        // // If roles are not found, you might want to create them
        // if (adminRole == null) {
        // adminRole = new RoleEntity();
        // adminRole.setRname("Admin");
        // roleRepo.save(adminRole); // Persist the new role
        // }

        // if (userRole == null) {
        // userRole = new RoleEntity();
        // userRole.setRname("User");
        // roleRepo.save(userRole); // Persist the new role
        // }

        // // Add roles to the user
        // roles.add(adminRole);
        // roles.add(userRole);
        // user.setRole(roles);

        userRepo.save(user);
    }

    @Transactional
    public UserEntity saveUser(UserEntity user) {
        if (user.getAddresses() != null) {

            for (AddressEntity address : user.getAddresses()) {
                address.setUser(user); // Set the user reference in each address
            }
        }

        // if (user.getRole() != null) {
        // for (RoleEnity role : user.getRole()) {
        // role.setRname(role.getRname()); // Ensure rname is populated
        // }
        // }
        return userRepo.save(user);
    }

    @Autowired
    private UserRoleRepository userRoleRepository;

    public void assignRoleToUser(Long userId, Long roleId) {
        UserEntity user = userRepo.findById(userId).orElseThrow();
        RoleEnity role = roleRepo.findById(roleId).orElseThrow();

        UserRole userRole = new UserRole(user, role);
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepository.save(userRole);
    }

    public List<UserEntity> findAllUsers() {
        return userRepo.findAll();
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }
}