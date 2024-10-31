package com.example.RBD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RBD.Entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity, Long> {

}
