package com.example.RBD.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;

import com.example.RBD.Entity.AddressEntity;
import com.example.RBD.Entity.RoleEnity;
import com.example.RBD.Repository.RoleRepo;
import com.example.RBD.Repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Transactional
    public RoleEnity saveRole(RoleEnity role) {
        return roleRepo.save(role);
    }

    public RoleEnity findRoleByName(String roleName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findRoleByName'");
    }

    // public List<RoleEnity> findAllRoles() {
    // return roleRepo.findAll();
    // }

    // public RoleEnity findRoleByName(String roleName) {
    // return roleRepo.findByRoleName(roleName);
    // }

}