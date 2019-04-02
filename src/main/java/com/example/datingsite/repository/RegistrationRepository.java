package com.example.datingsite.repository;

import com.example.datingsite.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {

    boolean existsById(Long id);

    boolean existsByLoginIgnoreCase(String login);

    boolean existsByEmailIgnoreCase(String email);

    Optional<RegistrationEntity> findByEmailIgnoreCase(String email);

}
