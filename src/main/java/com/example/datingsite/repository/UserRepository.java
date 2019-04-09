package com.example.datingsite.repository;

import com.example.datingsite.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsById(Long id);

    boolean existsByFirstnameIgnoreCase(String firstName);
}


