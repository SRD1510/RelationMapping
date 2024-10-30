package com.example.RBD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.RBD.Entity.UserEntity;
//mport com.example.RBD.Service.UserService;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByUseremail(String userEmail);
}
