package com.example.RBD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RBD.Entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

}
