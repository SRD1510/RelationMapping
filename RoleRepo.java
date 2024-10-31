package com.example.RBD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RBD.Entity.RoleEnity;

public interface RoleRepo extends JpaRepository<RoleEnity, Long> {
    RoleEnity findByRoleName(String roleName);
}
