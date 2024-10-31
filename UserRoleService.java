package com.example.RBD.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RBD.Entity.RoleEnity;
import com.example.RBD.Entity.UserEntity;
import com.example.RBD.Entity.UserRole;
import com.example.RBD.Repository.UserRoleRepository;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRole createUserRole(UserEntity user, RoleEnity role) {
        UserRole userRole = new UserRole(user, role);
        return userRoleRepository.save(userRole);
    }

    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}
