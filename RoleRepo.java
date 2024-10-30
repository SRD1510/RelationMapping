package com.example.RBD.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RBD.Entity.RoleEntity;
//import com.example.RBD.Entity.UserEntity;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByrname(String rname);

}
